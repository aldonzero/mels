package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.MachineryService;
import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.MachineryType;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.MachineryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MachineryServiceImpl extends BaseServiceImpl<Machinery>
        implements MachineryService {

    @Autowired
    private MachineryMapper machineryMapper;



    @Override
    public PageResult list(Pagination<Machinery> pagination, Machinery machinery) {
        Map<String, Object> prams = new HashMap<>();
        prams.put("currIndex", (pagination.getPage()-1)*pagination.getPageSize());
        prams.put("pageSize", pagination.getPageSize());
        prams.put("no",machinery.getNo());
        prams.put("machineryId",machinery.getMachineryId());
        PageResult pageResult = new PageResult();
        pageResult.setList(machineryMapper.list(prams));
        pageResult.setTotal(machineryMapper.listCount(prams));
        return pageResult;
    }
}
