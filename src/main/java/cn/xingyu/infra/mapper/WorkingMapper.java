package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.Working;
import cn.xingyu.domain.entity.WorkingEVO;
import org.hibernate.validator.constraints.NotEmpty;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkingMapper extends Mapper<Working> {

    List<WorkingEVO> list(Map<String, Object> prams);

    Integer listCount(Map<String, Object> prams);

}

