package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.EExitService;
import cn.xingyu.domain.entity.EExit;
import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.EExitMapper;
import cn.xingyu.infra.mapper.EIntoMapper;
import cn.xingyu.infra.mapper.MachineryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EExitServiceImpl extends BaseServiceImpl<EExit>
        implements EExitService {
    @Autowired
    private EExitMapper mapper;

    @Autowired
    private MachineryMapper machineryMapper;

    @Override
    public Long insert(EExit eExit) {
        Machinery machinery = new Machinery();
        machinery.setId(eExit.getMachineryId());
        //设备更新为工作状态
        machinery.setState((long) 1);
        if(machineryMapper.updateByPrimaryKeySelective(machinery) > 0)
            return super.insert(eExit);
        else
            return Long.valueOf(0);
    }

    @Override
    public PageResult list(Pagination<EExit> pagination, HashMap params) {
        Map<String, Object> prams = new HashMap<>();
        prams.put("currIndex", (pagination.getPage() - 1) * pagination.getPageSize());
        prams.put("pageSize", pagination.getPageSize());
        prams.put("machineryNo", params.get("machineryNo"));
        prams.put("projectName", params.get("projectName"));
        PageResult pageResult = new PageResult();
        pageResult.setList(mapper.list(prams));
        pageResult.setTotal(mapper.listCount(prams));
        return pageResult;
    }
}

