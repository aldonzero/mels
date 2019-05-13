package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.MachineryEVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MachineryMapper extends Mapper<Machinery> {
    List<MachineryEVO> list(Map<String, Object> prams);

    Integer listCount(Map<String, Object> prams);
}
