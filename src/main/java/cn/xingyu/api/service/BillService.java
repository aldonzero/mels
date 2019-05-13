package cn.xingyu.api.service;

import cn.xingyu.domain.entity.Bill;
import cn.xingyu.domain.entity.BillChart;

import java.util.Date;
import java.util.List;

public interface BillService extends BaseService<Bill> {
     List<BillChart> listChart(String year);
 }

