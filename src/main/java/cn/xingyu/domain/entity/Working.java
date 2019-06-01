package cn.xingyu.domain.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

@Data
public class Working {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private String no;
    private Long projectId;
    private Long machineryId;
    private BigDecimal workingHour;
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workingDate;
    private String agent;
    private Long state;
    private String remark;
    private Long auditUser;
    private String auditOpinion;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date auditDate;


}
