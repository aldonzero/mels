package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.CurrentUser;
import cn.xingyu.domain.entity.User;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
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

    private UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }




    @RequestMapping("/current")
    public Result findCurrent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null){
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
}
