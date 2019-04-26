package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.BaseService;
import cn.xingyu.api.service.MachineryService;
import cn.xingyu.api.service.MachineryTypeService;
import cn.xingyu.domain.entity.MachineryType;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/machineryType")
public class MachineryTypeController extends BaseController<MachineryType> {
    private Logger logger = (Logger) LoggerFactory.getLogger(MachineryTypeController.class);

    public MachineryTypeController(MachineryTypeService service) {
        super(service);
    }


}
