package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.StockPrice1MinDao;
import com.citi.gunrose.persistence.model.Stock;
import com.citi.gunrose.persistence.model.Stockprice1Min;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tangjing on 2017/8/7.
 */
@Repository("stockPriceDao")
public class StockPrice1MinDaoImpl extends BaseDaoImpl<Stockprice1Min> implements StockPrice1MinDao {
    @Override
    public List<Object[]> selectListByStockName(String stockName, int maxSize) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select s.Date,s.Open,s.Close,s.Low,s.High  from data_analysis.stockprice_1min as s where s.StockName ='"+stockName+"'");
        sqlQuery.setMaxResults(maxSize);
        List<Object[]> result = sqlQuery.list();

        for(Object[] each : result) {
            try {
                Date date = new SimpleDateFormat("yyyyMMddHHmm").parse((String) each[0]);
                each[0] = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
            }
            catch (ParseException e) {
                e.printStackTrace();

            }
        }

        //不使用Entity的原因是只需要5个数据
        //List<Stockprice1Min> test = sqlQuery.list();
        //List<Stockprice1Min> result = this.findByHQL("from Stockprice1Min as s where s.stockName=:stockName", stockName);
        return result;
    }
}
