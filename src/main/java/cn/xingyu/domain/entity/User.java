package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long userId;
  private Long userNo;
  private String userName;
  private Long sex;
  private String password;
  private String phone;
  private Long certificateType;
  private String userPicture;
  private Long departmentId;
  private Long roleId;
  private String available;
  private String userRemark;


}
