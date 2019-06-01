package cn.xingyu.api.service;

import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;

import java.util.HashMap;

public interface BaseService<T> {
    Long insert(T t);

    Integer update(T t);

    Integer delete(T t);

    T findById(T t);

    PageResult list(Pagination<T> pagination, T t);

    PageResult list(Pagination<T> pagination, HashMap params);

    T find(T t);

    Integer audit(T t);


}
