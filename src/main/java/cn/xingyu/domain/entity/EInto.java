package cn.xingyu.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Data
public class EInto {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long id;
  private Long projectId;
  private Long machineryId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date intoDate;
  private Long createUser;
  private Date createDate;


}
