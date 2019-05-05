package cn.xingyu.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long id;
  private Long no;
  private String name;
  private Long sex;
  private String password;
  private String phone;
  private Long certificateType;
  private String picture;
  private Long departmentId;
  private Long roleId;
  private Boolean available;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date createDate;
  private String remark;


}
