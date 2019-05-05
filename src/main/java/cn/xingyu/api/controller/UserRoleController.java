package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.UserRoleService;
import cn.xingyu.domain.entity.UserRole;
import cn.xingyu.domain.entity.UserRoleEVO;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    private Logger logger = (Logger) LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    private UserRoleService service;

    @GetMapping
    public Result list(UserRole userRole) {
        Result result = new Result();
        PageResult pageResult = new PageResult();
        pageResult.setList(service.list(userRole));
        result.setData(pageResult);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }


    @PutMapping
    public Result update(@RequestBody UserRoleEVO userRoleEVO) {
        service.delete(userRoleEVO.getUserId());

        List<UserRole> userRoles = new ArrayList<>();
        for (Long roleId:userRoleEVO.getRoleIds()) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userRoleEVO.getUserId());
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        }


        String msg = ResultStatus.UPDATE_SUCCESS.getStatusMsg();
        if (service.insetList(userRoles) <= 0) {
            msg = "修改失败";
        }
        Result result = new Result();
        result.setCode(ResultStatus.UPDATE_SUCCESS.getStatusCode());
        result.setMsg(msg);
        return result;
    }

}

