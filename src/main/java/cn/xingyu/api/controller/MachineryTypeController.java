package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.MachineryTypeService;
import cn.xingyu.domain.entity.MachineryType;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/machineryType")
public class MachineryTypeController extends BaseController<MachineryType> {
    private Logger logger = (Logger) LoggerFactory.getLogger(MachineryTypeController.class);

    public MachineryTypeController(MachineryTypeService service) {
        super(service);
    }


}
