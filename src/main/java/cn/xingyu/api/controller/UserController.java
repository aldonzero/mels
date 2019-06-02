package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.CurrentUser;
import cn.xingyu.domain.entity.PasswordEvo;
import cn.xingyu.domain.entity.User;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Value("${jasypt.encryptor.password}")
    private String salt;

    private UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/current")
    public Result findCurrent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            response.setStatus(401);
            try {
                response.getWriter().append("登录过期请重新登录！");
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user = new User();
        user.setId(userId);
        Result result = new Result();
        user = service.findById(user);
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUserid(user.getId());
        currentUser.setName(user.getName());
        currentUser.setPhone(user.getPhone());
        currentUser.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
        result.setData(currentUser);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }

    @PutMapping("/newPwd")
    public Result newPassword(@RequestBody PasswordEvo passwordEvo, HttpServletRequest request, HttpServletResponse response) {
        String msg = ResultStatus.UPDATE_SUCCESS.getStatusMsg();
        Integer code = ResultStatus.UPDATE_SUCCESS.getStatusCode();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            response.setStatus(401);
            try {
                response.getWriter().append("登录过期请重新登录！");
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User old = new User();
        old.setId(userId);
        old = service.find(old);
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(salt);
        if (old != null ) {
            String password = textEncryptor.decrypt(old.getPassword());
            logger.info("the new password is :" + password+"newpass:"+passwordEvo.getOldPassword());
            if (password.equals(passwordEvo.getOldPassword())){
                old.setPassword(textEncryptor.encrypt(passwordEvo.getPassword()));
                if (service.update(old) <= 0) {
                    msg = "修改失败";
                    code = -1;
                }
            }else {
                code = -1;
                msg = "旧密码出错";
            }
        }

        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
