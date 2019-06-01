package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    @Update("update permission set available=#{0} where parentid=#{1}")
    public void updateAvailable(boolean available, Long parentid);


    @Select("SELECT percode FROM permission WHERE id IN(\n" +
            "SELECT permission_id FROM role_permission WHERE role_id IN(\n" +
            "SELECT role_id FROM user_role WHERE user_id = #{0}))")
    List<String> listCode(Long userId);

    @Select("SELECT percode FROM permission WHERE id IN(\n" +
            "SELECT permission_id FROM role_permission WHERE role_id IN(\n" +
            "SELECT role_id FROM user_role WHERE user_id = #{arg0})) AND percode LIKE  CONCAT(#{arg1},'%') ")
    List<String> listPageCode(Long userId, String module);
}

