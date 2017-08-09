package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.StockDao;
import com.citi.gunrose.persistence.model.Stock;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {
    @Override
    public List<String> selectNames(int maxSize) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select s.StockName from data_analysis.stock s");
        sqlQuery.setMaxResults(maxSize);
        return (List<String>) sqlQuery.list();
    }

    @Override
    public List<String> searchNames(int marketID, String term) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select s.StockName from data_analysis.stock s where s.MarkID =" + marketID + " and s.StockName like '%" + term + "%'");
        sqlQuery.setMaxResults(20);
        return (List<String>) sqlQuery.list();
    }
}
