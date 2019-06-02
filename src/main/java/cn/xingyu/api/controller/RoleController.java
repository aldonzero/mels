package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.RoleService;
import cn.xingyu.domain.entity.Role;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {
    private Logger logger = (Logger) LoggerFactory.getLogger(RoleController.class);

    public RoleController(RoleService service) {
        super(service);
    }

}

