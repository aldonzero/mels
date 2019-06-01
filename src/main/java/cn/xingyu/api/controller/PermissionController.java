package cn.xingyu.api.controller;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.PermissionService;
import cn.xingyu.api.service.impl.PermissionServiceImpl;
import cn.xingyu.domain.entity.Permission;
import cn.xingyu.domain.entity.result.Result;
import cn.xingyu.domain.entity.result.ResultStatus;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<Permission> {
    private Logger logger = (Logger) LoggerFactory.getLogger(PermissionController.class);

    private PermissionService permissionService;

    public PermissionController(PermissionService service) {
        super(service);
        this.permissionService = service;
    }

    @GetMapping("/page")
    public Result findPagePermission(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessoin = request.getSession();//这就是session的创建
        Long userId = (Long) sessoin.getAttribute("userId");
        if (userId == null) {
            response.setStatus(401);
            return null;
        }
        String module = request.getParameter("page");
        Result result = new Result();
        result.setData(permissionService.listCode(userId, module));
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }
}

