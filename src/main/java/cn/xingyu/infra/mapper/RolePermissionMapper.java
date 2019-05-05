package cn.xingyu.infra.mapper;
 
 import cn.xingyu.domain.entity.RolePermission;
 import tk.mybatis.mapper.common.Mapper;
 import tk.mybatis.mapper.common.MySqlMapper;

public interface RolePermissionMapper extends Mapper<RolePermission>,MySqlMapper<RolePermission> {
 }

