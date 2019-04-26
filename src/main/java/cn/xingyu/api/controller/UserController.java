package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    public UserController(UserService service) {
        super(service);
    }




}
