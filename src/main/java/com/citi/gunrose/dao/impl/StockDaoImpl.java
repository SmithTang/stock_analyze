package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.StockDao;
import com.citi.gunrose.persistence.model.Stock;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {

    public List<Stock> queryStockByName(String name) {

        SQLQuery sqlQuery1 = this.getSession().createSQLQuery("select * from stock as s where s.StockName ='"+name+"'");
        sqlQuery1.addEntity(Stock.class);
        List<Stock> stocks = sqlQuery1.list();

        return stocks;
    }
}
