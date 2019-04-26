package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.MachineryService;
import cn.xingyu.domain.entity.Machinery;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machinery")
public class MachineryController extends BaseController<Machinery> {
    private Logger logger = (Logger) LoggerFactory.getLogger(MachineryController.class);

    public MachineryController(MachineryService service) {
        super(service);
    }
}
