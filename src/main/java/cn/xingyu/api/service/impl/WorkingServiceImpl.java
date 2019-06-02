package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.WorkingService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.Working;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.WorkingMapper;
import cn.xingyu.infra.utils.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WorkingServiceImpl extends BaseServiceImpl<Working>
        implements WorkingService {

    @Autowired
    private WorkingMapper workingMapper;

    @Override
    public PageResult list(Pagination<Working> pagination, Working working) {
        Map<String, Object> prams = new HashMap<>();
        prams.put("currIndex", (pagination.getPage()-1)*pagination.getPageSize());
        prams.put("pageSize", pagination.getPageSize());
        PageResult pageResult = new PageResult();
        pageResult.setList(workingMapper.list(prams));
        pageResult.setTotal(workingMapper.listCount(prams));
        return pageResult;
    }



    @Override
    public Integer audit(Working working) {
        Long userId = (Long) ServletUtil.getRequest().getSession().getAttribute("userId");
        if(userId == null){
            throw new cn.xingyu.domain.exception.LoginException(401,"未登录或登录已经过期");
        }
        working.setAuditUser(userId);
        working.setAuditDate(new Date());
        return super.audit(working);
    }
}

