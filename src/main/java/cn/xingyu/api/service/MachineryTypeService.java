package cn.xingyu.api.service;

import cn.xingyu.domain.entity.MachineryType;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;

import java.util.List;

public interface MachineryTypeService extends BaseService<MachineryType>  {
    Long insert(MachineryType machineryType);

    Integer update(MachineryType machineryType);

    Integer delete(MachineryType machineryType);

    MachineryType findById(MachineryType machineryType);

    PageResult list(Pagination<MachineryType> pagination,MachineryType machineryType);
}
