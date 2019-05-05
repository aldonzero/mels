package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.RolePermissionService;
 import cn.xingyu.domain.entity.Pagination;
 import cn.xingyu.domain.entity.RolePermission;
 import cn.xingyu.domain.entity.RolePermissionEVO;
 import cn.xingyu.domain.entity.result.PageResult;
 import cn.xingyu.domain.entity.result.Result;
 import cn.xingyu.domain.entity.result.ResultStatus;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;

@RestController
 @RequestMapping("/rolePermission")
 public class RolePermissionController  {
 	private Logger logger = (Logger) LoggerFactory.getLogger(RolePermissionController.class);

 	@Autowired
    private RolePermissionService service;

    @GetMapping
    public Result list(RolePermission rolePermission) {
        Result result = new Result();
        PageResult pageResult = new PageResult();
        pageResult.setList(service.list(rolePermission));
        result.setData(pageResult);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }


     @PutMapping
     public Result update(@RequestBody RolePermissionEVO rolePermissionEVO) {
         logger.info("roleId is:"+rolePermissionEVO.getRoleId());
         logger.info(Arrays.toString(rolePermissionEVO.getPermissions()));
         service.delete(rolePermissionEVO.getRoleId());

         List<RolePermission> rolePermissions = new ArrayList<>();
         for (Long permissiongId:rolePermissionEVO.getPermissions()) {
             RolePermission rolePermission = new RolePermission();
             rolePermission.setRoleId(rolePermissionEVO.getRoleId());
             rolePermission.setPermissionId(permissiongId);
             rolePermissions.add(rolePermission);
         }


         String msg = ResultStatus.UPDATE_SUCCESS.getStatusMsg();
         if (service.insetList(rolePermissions) <= 0) {
             msg = "修改失败";
         }
         Result result = new Result();
         result.setCode(ResultStatus.UPDATE_SUCCESS.getStatusCode());
         result.setMsg(msg);
         return result;
     }

 }

