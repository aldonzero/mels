package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;

import cn.xingyu.domain.entity.MachineryType;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import cn.xingyu.api.service.BaseService;
import cn.xingyu.infra.utils.Property;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;

@RestController
@RequestMapping
public abstract class BaseController<T> {
    private Logger logger = (Logger) LoggerFactory.getLogger(BaseController.class);
    private BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @GetMapping
    public Result list(Pagination<T> pagination, T t) {
        logger.info("find " + t.getClass().getSimpleName() + " by pagination");
        logger.info(pagination.toString());
        Result result = new Result();
        PageResult pageResult = service.list(pagination, t);
        pageResult.setCurrent(pagination.getPage());
        pageResult.setPageSize(pagination.getPageSize());
        result.setData(pageResult);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }

    /**
     * 获取要查询的参数
     *
     * @param request
     * @param t
     * @return
     */
    public T getRequestT(HttpServletRequest request, T t) {
        return t;
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Long id, T t) {
        logger.info("select " + t.getClass().getSimpleName() + " by id");
        Property property = new Property();
        t = (T) property.idSet(t, id);
        t = service.findById(t);
        System.out.println(t.toString());
        Result result = new Result();
        result.setData(t);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }

    @PostMapping
    public Result Insert(@RequestBody T t) {
        logger.info("Insert " + t.getClass().getSimpleName());
        Result result = new Result();
        HashMap resultMap = new HashMap();
        resultMap.put("id", service.insert(t));
        result.setData(resultMap);
        result.setCode(ResultStatus.INSERT_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.INSERT_SUCCESS.getStatusMsg());
        return result;
    }

    @PutMapping
    public Result update(@RequestBody T t) {
        logger.info("update " + t.getClass().getSimpleName());
        String msg = ResultStatus.UPDATE_SUCCESS.getStatusMsg();
        if (service.update(t) <= 0) {
            msg = "修改失败";
        }
        Result result = new Result();
        result.setCode(ResultStatus.UPDATE_SUCCESS.getStatusCode());
        result.setMsg(msg);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id, T t) {
        Property property = new Property();
        t = (T) property.idSet(t, id);
        logger.info("Delete " + t.getClass().getSimpleName() + " with id is " + id);
        service.delete(t);
        System.out.println(toString());
        Result result = new Result();
        result.setCode(ResultStatus.DELETE_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.DELETE_SUCCESS.getStatusMsg());
        return result;
    }


}
