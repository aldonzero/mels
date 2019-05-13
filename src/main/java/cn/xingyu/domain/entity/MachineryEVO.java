package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MachineryEVO {
    @Id
    @KeySql(useGeneratedKeys = true,dialect=IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
  private Long id;
  private String no;
  private String model;
  private String brand;
  private MachineryType machineryType;
  private BigDecimal purchasingPrice;
  private Date purchasingDate;
  private Long state;
  private String description;


}
