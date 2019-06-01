package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.EInto;
import cn.xingyu.domain.entity.EIntoEVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface EIntoMapper extends Mapper<EInto> {

    List<EIntoEVO> list(Map<String, Object> prams);

    Integer listCount(Map<String, Object> prams);
}

