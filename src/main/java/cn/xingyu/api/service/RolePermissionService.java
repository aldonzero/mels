package cn.xingyu.api.service;
 
 import cn.xingyu.domain.entity.RolePermission;

 import java.util.List;

public interface RolePermissionService extends BaseService<RolePermission> {
  Integer delete(Long roleId);

  Integer insetList(List<RolePermission> rolePermissions);

  List<RolePermission> list(RolePermission rolePermission);
 }

