package cn.xingyu.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WorkingEVO {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private String no;
    private Project project;
    private Machinery machinery;
    private BigDecimal workingHour;
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workingDate;
    private String agent;
    private Long state;
    private String remark;
    private String auditUser;
    private String auditOpinion;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date auditDate;


}
