package cn.xingyu.infra.mapper;
 
 import cn.xingyu.domain.entity.Permission;
 import org.apache.ibatis.annotations.Update;
 import tk.mybatis.mapper.common.Mapper;
 
 public interface PermissionMapper extends Mapper<Permission> {

  @Update("update permission set available=#{0} where parentid=#{1}")
  public void updateAvailable(boolean available,Long parentid);
 }

