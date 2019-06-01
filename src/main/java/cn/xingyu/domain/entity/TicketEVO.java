package cn.xingyu.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TicketEVO {
    private Long id;
    private String projectName;
    private String ticketType;
    private BigDecimal cost;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date costDate;
    private String agent;
    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    private String remark;
    private Long state;
    private Long auditUser;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date auditDate;
    private String auditOption;

}
