package cn.xingyu.api.service;

import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.result.PageResult;

public interface BaseService<T> {
    Long insert(T t);

    Integer update(T t);

    Integer delete(T t);

    T findById(T t);

    PageResult list(Pagination<T> pagination,T t);

    T find(T t);
}
