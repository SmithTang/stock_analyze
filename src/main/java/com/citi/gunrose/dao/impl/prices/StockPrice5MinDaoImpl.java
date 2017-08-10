package com.citi.gunrose.dao.impl.prices;

import com.citi.gunrose.dao.impl.BaseDaoImpl;
import com.citi.gunrose.dao.prices.StockPrice5MinDao;
import com.citi.gunrose.persistence.model.Stockprice5Min;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
@Repository("stockPrice5MinDao")
public class StockPrice5MinDaoImpl extends BaseDaoImpl<Stockprice5Min> implements StockPrice5MinDao {
    @Override
    public List<Object[]> selectListByStockName(String stockName, int maxSize) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select s.Date,s.Open,s.Close,s.Low,s.High  from data_analysis.stockprice_5min as s where s.StockName ='"+stockName+"'");
        sqlQuery.setMaxResults(maxSize);
        List<Object[]> result = sqlQuery.list();

        //不使用Entity的原因是只需要5个数据
        //List<Stockprice1Min> test = sqlQuery.list();
        //List<Stockprice1Min> result = this.findByHQL("from Stockprice1Min as s where s.stockName=:stockName", stockName);
        return this.stockPriceFormater(result, "yyyyMMddHHmm");
    }
}
