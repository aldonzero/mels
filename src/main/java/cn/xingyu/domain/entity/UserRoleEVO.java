package cn.xingyu.domain.entity;

import lombok.Data;


@Data
public class UserRoleEVO {
    private Long userId;
    private Long[] roleIds;
}
