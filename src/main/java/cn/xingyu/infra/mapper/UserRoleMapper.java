package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.Role;
import cn.xingyu.domain.entity.UserRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole>, MySqlMapper<UserRole> {

    @Select("SELECT code FROM user_role LEFT JOIN role ON user_role.role_id = role.id WHERE user_id = #{userId}")
    List<Role> listRole(UserRole userRole);

    @Select("SELECT code FROM user_role LEFT JOIN role ON user_role.role_id = role.id WHERE user_id = #{userId}")
    List<String> listCode(Long userId);
}

