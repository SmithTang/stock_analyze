package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.BaseDao;
import com.citi.gunrose.persistence.model.Page;
import com.citi.gunrose.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 注入BaseDao
     */
    @Autowired
    private BaseDao<T> dao;

    public void save(T entity) {
        dao.save(entity);
    }

    public void update(T entity) {
        dao.update(entity);
    }

    public void delete(Serializable id) {
        dao.delete(id);
    }

    public T getById(Serializable id) {
        return dao.findById(id);
    }

    public List<T> getAll() {
        return dao.findAll();
    }

    public List<T> getByHQL(String hql, Object... params) {
        return dao.findByHQL(hql, params);
    }

    @Override
    public Page queryForPage(int currentPage, int pageSize, String hql, Object... params) {
        Page page = new Page();
        //总记录数
        //int allRow = dao.getAllRowCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List<T> list = dao.queryForPage(offset, pageSize, hql, params);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(list.size());
        page.setList(list);

        return page;
    }

}