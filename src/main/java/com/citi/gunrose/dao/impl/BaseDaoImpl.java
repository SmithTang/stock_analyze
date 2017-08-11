package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<T> queryForPage(int offset, int length, String hql, Object... params) {

        List<T> entitylist=null;
        try{
            Query query = this.getSession().createQuery(hql);
            for (int i = 0; params != null && i < params.length; i++) {
                query.setParameter(i, params);
            }
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();

        }catch(RuntimeException re){
            throw re;
        }

        return entitylist;
    }

    protected List<Object[]> stockPriceFormater(List<Object[]> input, String pattern) {
        for(Object[] each : input) {
            try {
                Date date = null;
                if(pattern.equals("yyyyMMddHHmm")) {
                    date = new SimpleDateFormat("yyyyMMddHHmm").parse((String) each[0]);
                    each[0] = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
                }
                else if(pattern.equals("yyyyMMdd")) {
                    date = new SimpleDateFormat("yyyyMMdd").parse((String) each[0]);
                    each[0] = new SimpleDateFormat("yyyy-MM-dd").format(date);
                }
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return input;
    }
}
