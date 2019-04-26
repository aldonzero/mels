package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.StaffService;
import cn.xingyu.domain.entity.Staff;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController extends BaseController<Staff> {
    private Logger logger = (Logger) LoggerFactory.getLogger(StaffController.class);

    public StaffController(StaffService service) {
        super(service);
    }




}
