package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.TicketService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.Ticket;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket>
        implements TicketService {

    @Autowired
    private TicketMapper mapper;
    
    @Override
    public PageResult list(Pagination<Ticket> pagination, Ticket ticket) {
        Map<String, Object> prams = new HashMap<>();
        prams.put("currIndex", (pagination.getPage() - 1) * pagination.getPageSize());
        prams.put("pageSize", pagination.getPageSize());
        prams.put("projectName", null);
        PageResult pageResult = new PageResult();
        pageResult.setList(mapper.list(prams));
        pageResult.setTotal(mapper.listCount(prams));
        return pageResult;
    }
}

