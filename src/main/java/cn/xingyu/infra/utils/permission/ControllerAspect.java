package cn.xingyu.infra.utils.permission;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.controller.BaseController;
import cn.xingyu.api.service.PermissionService;
import cn.xingyu.domain.exception.AuthorityException;
import cn.xingyu.domain.exception.LoginException;
import cn.xingyu.infra.utils.ServletUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
public class ControllerAspect {
    private Logger logger = (Logger) LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private PermissionService permissionService;
    /**
     * 定义切点AnnotationParse
     */
    @Pointcut("execution(public * cn.xingyu.api.controller.*.*(..))")
    public void privilege(){}

    /**
     * 权限环绕通知
     * @param joinPoint
     * @throws Throwable
     */
    @ResponseBody
    @Around("privilege()")
    public Object isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取访问目标方法
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method targetMethod = methodSignature.getMethod();
        //得到方法的访问权限
        final String methodAccess = AnnotationParse.privilegeParse(targetMethod);

        //如果该方法上没有权限注解，直接调用目标方法
        if(StringUtils.isBlank(methodAccess)){
            return joinPoint.proceed();
        }else {
            //获取当前用户的权限,这里是自定义的发那个发
            Long userId = (Long) ServletUtil.getRequest().getSession().getAttribute("userId");
            logger.info("userId:=>",userId);
            if(userId == null){
                throw new LoginException(401,"未登录或登录已经过期");
            }
            List<String> permissionCodes = permissionService.listCode(userId, methodAccess);
            HttpServletResponse response =  ServletUtil.getResponse();
            if (permissionCodes.size() == 0){
                throw new AuthorityException(HttpServletResponse.SC_FORBIDDEN,"该用户，无该权限");
            }

            for (int i = 0; i < permissionCodes.size(); i++) {
                if (permissionCodes.get(i).equals(methodAccess)){
                    return joinPoint.proceed();
                }else {
                    throw new AuthorityException(HttpServletResponse.SC_FORBIDDEN,"该用户，无该权限");
                }
            }

          return null;
        }
    }
}
