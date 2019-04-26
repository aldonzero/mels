package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.MachineryService;
import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.MachineryType;
import cn.xingyu.infra.mapper.MachineryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineryServiceImpl extends BaseServiceImpl<Machinery>
        implements MachineryService {

    @Autowired
    private MachineryMapper machineryMapper;


}
