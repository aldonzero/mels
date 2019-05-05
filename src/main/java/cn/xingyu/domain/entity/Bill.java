package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.math.BigDecimal;

@Data
public class Bill {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long billId;
  private String billNo;
  private Long projectId;
  private BigDecimal quantities;
  private BigDecimal price;
  private String agent;
  private Long state;
  private String remark;


}
