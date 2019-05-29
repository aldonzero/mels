package cn.xingyu.api.service.impl;

import ch.qos.logback.classic.Logger;
import cn.xingyu.api.service.BaseService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.utils.Property;
import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Id;
import java.lang.reflect.Field;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private Logger logger = (Logger) LoggerFactory.getLogger(BaseService.class);
    @Autowired
    private Mapper<T> mapper;



    @Override
    public Long insert(T t) {
        System.out.println(t.toString());
        mapper.insertSelective(t);
        mapper.selectByPrimaryKey(t);
        return (Long) idGet(t);
    }

    @Override
    public Integer update(T t) {
        int result =  mapper.updateByPrimaryKeySelective(t);
        logger.info("update result :" +result);
        return result;
    }

    @Override
    public Integer delete(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    @Override
    public T findById(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public PageResult list(Pagination<T> pagination,T t) {
        Example e = new Example(t.getClass());
        PageResult pageResult = new PageResult();
        Property property = new Property();
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize(), pagination.getSort());
        PageHelper.orderBy(pagination.getOrderBy() == null ? String.valueOf(idGet(t)) : pagination.getOrderBy());
        e = getExample(e,t);
        pageResult.setList(mapper.selectByExample(e));
        pageResult.setTotal(mapper.selectCountByExample(e));
        return pageResult;
    }

    public Example getExample(Example e,T t){
        return e;
    }

  @Override
    public T find(T t) {
        return mapper.selectOne(t);
    }

    /**
     * 获取Id注解的属性的值
     * @param t
     * @return
     */
    public Object idGet(T t)  {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Id.class)) {
                f.setAccessible(true);
                try {
                    return  f.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
