package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.EIntoService;
import cn.xingyu.domain.entity.EInto;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/eInto")
public class EIntoController extends BaseController<EInto> {
    private Logger logger = (Logger) LoggerFactory.getLogger(EIntoController.class);

    private EIntoService service;

    public EIntoController(EIntoService service) {
        super(service);
        this.service = service;
    }

    @Override
    public Result list(Pagination<EInto> pagination, EInto eInto, HttpServletRequest request) {
        pagination.setT(eInto);
        HashMap<String, Object> params = new HashMap<>();
        params.put("pageSize", pagination.getPageSize());
        params.put("machineryNo", request.getParameter("machineryNo"));
        params.put("projectName", request.getParameter("projectName"));


        Result result = new Result();
        PageResult pageResult = service.list(pagination, params);
        pageResult.setCurrent(pagination.getPage());
        pageResult.setPageSize(pagination.getPageSize());
        result.setData(pageResult);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }


}

