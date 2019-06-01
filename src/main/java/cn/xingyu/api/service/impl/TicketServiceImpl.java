package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.TicketService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.Ticket;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.TicketMapper;
import cn.xingyu.infra.utils.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket>
        implements TicketService {

    @Autowired
    private TicketMapper mapper;

    @Override
    public PageResult list(Pagination<Ticket> pagination, HashMap params) {
        Map<String, Object> prams = new HashMap<>();
        prams.put("currIndex", (pagination.getPage() - 1) * pagination.getPageSize());
        prams.put("pageSize", pagination.getPageSize());
        prams.put("ticketType", params.get("ticketType"));
        prams.put("projectName", params.get("projectName"));
        PageResult pageResult = new PageResult();
        pageResult.setList(mapper.list(prams));
        pageResult.setTotal(mapper.listCount(prams));
        return pageResult;
    }

    @Override
    public Integer audit(Ticket ticket) {
        Long userId = (Long) ServletUtil.getRequest().getSession().getAttribute("userId");
        if(userId == null){
            throw new cn.xingyu.domain.exception.LoginException(401,"未登录或登录已经过期");
        }
        ticket.setAuditDate(new Date());
        ticket.setAuditUser(userId);
        return super.audit(ticket);
    }
}

