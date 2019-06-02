package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class Project {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long id;
  private String no;
  private String projectName;
  private String address;
  private Long estimate;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date startDate;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date endDate;
  private Long state;
  private String description;
  private String constructionUnit;
  private String unitContacts;
  private String unitPhone;
  private String unitAddress;
  private Long auditUser;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date auditDate;
  private String auditOpinion;


}
