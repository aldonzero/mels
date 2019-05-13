package cn.xingyu.infra.mapper;

import cn.xingyu.domain.entity.Bill;
import cn.xingyu.domain.entity.BillChart;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface BillMapper extends Mapper<Bill> {

    @Select("SELECT SUM(quantities*price) as total,pay_date as date FROM bill WHERE DATE_FORMAT(pay_date,'%Y') = #{0} GROUP BY pay_date")
    List<BillChart> listChart(String year);
}

