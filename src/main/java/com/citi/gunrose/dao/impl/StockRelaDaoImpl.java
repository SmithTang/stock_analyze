package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.StockRelaDao;
import com.citi.gunrose.persistence.model.StockRela;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
@Repository("stockRelaDao")
public class StockRelaDaoImpl extends BaseDaoImpl<StockRela> implements StockRelaDao {

    @Override
    public List<StockRela> selectRela(String stock1) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select * from data_analysis.stock_rela s where s.Stock1='" + stock1 + "' and s.CCValue != 1 order by s.CCValue DESC");
        sqlQuery.addEntity(StockRela.class);
        sqlQuery.setMaxResults(50);
        return (List<StockRela>) sqlQuery.list();
    }
}
