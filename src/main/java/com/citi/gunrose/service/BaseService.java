package com.citi.gunrose.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
public interface BaseService<T> {
    public void save(T entity);

    public void update(T entity);

    public void delete(Serializable id);

    public T getById(Serializable id);

    public List<T> getByHQL(String hql, Object... params);
}
