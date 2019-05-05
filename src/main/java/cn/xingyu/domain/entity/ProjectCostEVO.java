package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjectCostEVO {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long id;
  private String no;
  private Project project;
  private Machinery machinery;
  private Long type;
  private BigDecimal cost;
  private Date costDate;
  private String agent;
  private String remark;


}
