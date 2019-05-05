package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.RolePermissionService;
import cn.xingyu.domain.entity.RolePermission;
import cn.xingyu.infra.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission>
        implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public Integer delete(Long roleId) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        return rolePermissionMapper.delete(rolePermission);
    }

    @Override
    public Integer insetList(List<RolePermission> rolePermissions) {
        return rolePermissionMapper.insertList(rolePermissions);
    }

    @Override
    public List<RolePermission> list(RolePermission rolePermission) {
        return rolePermissionMapper.select(rolePermission);
    }
}

