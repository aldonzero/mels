package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.ProjectCostService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.ProjectCost;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.ProjectCostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProjectCostServiceImpl extends BaseServiceImpl<ProjectCost>
        implements ProjectCostService {

    @Autowired
    private ProjectCostMapper projectCostMapper;

    @Override
    public PageResult list(Pagination<ProjectCost> pagination, ProjectCost projectCost) {
        Map<String, Object> prams = new HashMap<>();
        prams.put("currIndex", (pagination.getPage()-1)*pagination.getPageSize());
        prams.put("pageSize", pagination.getPageSize());
        PageResult pageResult = new PageResult();
        pageResult.setList(projectCostMapper.list(prams));
        pageResult.setTotal(projectCostMapper.listCount(prams));
        return pageResult;
    }
}

