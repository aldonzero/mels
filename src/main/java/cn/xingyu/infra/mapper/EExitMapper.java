package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.EExit;
import cn.xingyu.domain.entity.EExitEVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface EExitMapper extends Mapper<EExit> {
    List<EExitEVO> list(Map<String, Object> prams);

    Integer listCount(Map<String, Object> prams);
}

