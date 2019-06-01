package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.EIntoService;
import cn.xingyu.domain.entity.EInto;
import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.EIntoMapper;
import cn.xingyu.infra.mapper.MachineryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EIntoServiceImpl extends BaseServiceImpl<EInto>
        implements EIntoService {
    @Autowired
    private EIntoMapper mapper;

    @Autowired
    private MachineryMapper machineryMapper;

    @Override
    public Long insert(EInto eInto) {
        Machinery machinery = new Machinery();
        machinery.setId(eInto.getMachineryId());
        //设备更新为工作状态
        machinery.setState((long) 2);
        if(machineryMapper.updateByPrimaryKeySelective(machinery) > 0)
            return super.insert(eInto);
        else
            return Long.valueOf(0);
    }


    @Override
    public PageResult list(Pagination<EInto> pagination, HashMap params) {
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

