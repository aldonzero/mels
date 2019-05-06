package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.UserRoleService;
import cn.xingyu.domain.entity.Role;
import cn.xingyu.domain.entity.UserRole;
import cn.xingyu.infra.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole>
        implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public Integer delete(Long userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        return userRoleMapper.delete(userRole);
    }

    @Override
    public Integer insetList(List<UserRole> userRoles) {
        return userRoleMapper.insertList(userRoles);
    }

    @Override
    public List<UserRole> list(UserRole userRole) {
        return userRoleMapper.select(userRole);
    }

    @Override
    public List<Role> listRole(UserRole userRole) {
        return userRoleMapper.listRole(userRole);
    }

    @Override
    public List<String> listCode(Long userId) {
        return userRoleMapper.listCode(userId);
    }
}

