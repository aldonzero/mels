package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.BillService;
import cn.xingyu.domain.entity.Bill;
import cn.xingyu.domain.entity.BillChart;
import cn.xingyu.infra.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl extends BaseServiceImpl<Bill>
        implements BillService {

    @Autowired
    private BillMapper mapper;

    @Override
    public List<BillChart> listChart(String year) {
        return mapper.listChart(year);
    }
}

