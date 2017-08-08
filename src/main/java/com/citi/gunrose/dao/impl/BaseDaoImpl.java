package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private Class<T> clazz;

    /**
     * 通过构造方法指定DAO的具体实现类
     */
    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * 向DAO层注入SessionFactory
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取当前工作的Session
     */
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        this.getSession().save(entity);
    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public void delete(Serializable id) {
        this.getSession().delete(this.findById(id));
    }

    public T findById(Serializable id) {
        return (T) this.getSession().get(this.clazz, id);
    }

    public List<T> findAll() {
        return (List<T>) this.getSession().createQuery("from " + this.clazz.getName()).list();
    }

    public List<T> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }
}
