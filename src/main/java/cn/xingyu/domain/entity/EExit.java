package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class EExit {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long id;
  private Long projectId;
  private Long machineryId;
@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date exitDate;
  private Long createUser;
@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date createDate;
  private String reason;


}
