package cn.xingyu.api.service;

import cn.xingyu.domain.entity.UserRole;

import java.util.List;

public interface UserRoleService extends BaseService<UserRole> {
    Integer delete(Long userId);

    Integer insetList(List<UserRole> userRoles);

    List<UserRole> list(UserRole userRole);
}

