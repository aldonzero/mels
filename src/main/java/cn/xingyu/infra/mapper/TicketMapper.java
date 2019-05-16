package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.Ticket;
import cn.xingyu.domain.entity.TicketEVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TicketMapper extends Mapper<Ticket> {
    List<TicketEVO> list(Map<String, Object> prams);

    Integer listCount(Map<String, Object> prams);
}

