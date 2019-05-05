package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.ProjectCost;
import cn.xingyu.domain.entity.ProjectCostEVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ProjectCostMapper extends Mapper<ProjectCost> {
    List<ProjectCostEVO> list(Map<String, Object> prams);

    Integer listCount(Map<String, Object> prams);
}

