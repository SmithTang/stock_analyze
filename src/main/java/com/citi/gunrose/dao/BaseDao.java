package com.citi.gunrose.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
public interface BaseDao<T> {
    public void save(T entity);

    public void update(T entity);

    public void delete(Serializable id);

    public T findById(Serializable id);

    public List<T> findAll();

    public List<T> findByHQL(String hql, Object... params);
}
