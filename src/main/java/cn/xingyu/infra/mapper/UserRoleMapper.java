package cn.xingyu.infra.mapper;
 
 import cn.xingyu.domain.entity.UserRole;
 import tk.mybatis.mapper.common.Mapper;
 import tk.mybatis.mapper.common.MySqlMapper;

public interface UserRoleMapper extends Mapper<UserRole>,MySqlMapper<UserRole> {
 }

