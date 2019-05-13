package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.PermissionService;
import cn.xingyu.api.service.RolePermissionService;
import cn.xingyu.api.service.UserRoleService;
import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.*;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    private Logger logger = (Logger) LoggerFactory.getLogger(BillController.class);

    @Value("${jasypt.encryptor.password}")
    private String salt;

    @Autowired
    private UserService userService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/login")
    public Result findById(@RequestBody UserEVO userEVO,HttpServletRequest request) {
        logger.info("userInfo is" + userEVO.toString());
        Result result = new Result();
        String msg = "error";
        if (userEVO.getPhone() != null) {
            User user = new User();
            user.setPhone(userEVO.getPhone());
            user = userService.find(user);
            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword(salt);
            if (user != null ) {
                String password = textEncryptor.decrypt(user.getPassword());
                logger.info("the new password is :" + password);
                if (password.equals(userEVO.getPassword())){
                    msg = "success";

                    HttpSession sessoin=request.getSession();//这就是session的创建
                    sessoin.setAttribute("userId",user.getId());

                    CurrentUser currentUser = new CurrentUser();
                    currentUser.setUserid(user.getId());
                    currentUser.setName(user.getName());
                    currentUser.setPhone(user.getPhone());
                    currentUser.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");

                    //获取角色信息
                    Map<String,Object> resMap = new HashMap<>();
                    resMap.put("authority",permissionService.listCode(user.getId()).toArray());
                    resMap.put("currentUser",currentUser);
//                    logger.info(Arrays.toString(userRoleService.listCode(user.getId()).toArray()));
                    result.setData(resMap);
                }
            }
        }
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(msg);
        return result;
    }



}
