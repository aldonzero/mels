package cn.xingyu.api.service.impl;

import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.MachineryType;
import cn.xingyu.api.service.MachineryTypeService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.MachineryTypeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

@Service
public class MachineryTypeServiceImpl extends BaseServiceImpl<MachineryType>
        implements MachineryTypeService {
    @Autowired
    private MachineryTypeMapper machineryTypeMapper;




//    @Override
//    public PageResult list(Pagination<MachineryType> pagination) {
//        Example e = new Example(MachineryType.class);
//        Example.Criteria c = e.createCriteria();
//        //关键字查询部分
//        if (pagination.getT() != null) {
//            MachineryType machineryType = pagination.getT();
//            String name = machineryType.getName();
//            if (name != null && name.trim() != "") {
//                c.andLike("name", "%" + name + "%");
//            }
//        }
//
//        PageResult pageResult = new PageResult();
//        PageHelper.startPage(pagination.getPage(), pagination.getPageSize(), pagination.getSort());
//        PageHelper.orderBy(pagination.getOrderBy() == null ? "id" : pagination.getOrderBy());
//
//        pageResult.setList(machineryTypeMapper.selectByExample(e));
//        pageResult.setTotal(machineryTypeMapper.selectCountByExample(e));
//        return pageResult;
//    }
}
