package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.MarketDao;
import com.citi.gunrose.persistence.model.Market;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
@Repository("marketDao")
public class MarketDaoImpl extends BaseDaoImpl<Market> implements MarketDao {
    @Override
    public List<Object[]> queryMostPickedStocks() {
        String sql = "SELECT StockName,COUNT(StockName) as Num FROM portfolio GROUP BY StockName ORDER BY Num DESC LIMIT 5";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<Object[]> obj = sqlQuery.list();
        return obj;
    }
    public BigInteger queryStockNumber() {
        String sql = "SELECT COUNT(StockName) as Num FROM portfolio GROUP BY StockName ORDER BY Num DESC LIMIT 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<BigInteger> num = sqlQuery.list();
        return num.get(0);
    }
    public List<Object[]> queryMostVolumeStocks() {
        String sql = "SELECT StockName,Volume FROM stockprice_1day WHERE Date = '20110601' ORDER BY Volume DESC LIMIT 5";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<Object[]> obj = sqlQuery.list();
        return obj;
    }
    public Integer queryVolumeNumber() {
        String sql = "SELECT Volume FROM stockprice_1day WHERE Date = '20110601' ORDER BY Volume DESC LIMIT 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<Integer> num = sqlQuery.list();
        return num.get(0);
    }
    public List<Object[]> queryMostIncreaseStocks() {
        String sql = "SELECT StockName,ROUND((`Close` - `Open` )/`Close`*100,2) as Increase FROM stockprice_1day WHERE Date = '20110601' ORDER BY Increase DESC LIMIT 5";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<Object[]> obj = sqlQuery.list();
        return obj;
    }
    public BigDecimal queryIncreaseNumber() {
        String sql = "SELECT ROUND((`Close` - `Open` )/`Close`*100,2) as Increase FROM stockprice_1day WHERE Date = '20110601' ORDER BY Increase DESC LIMIT 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<BigDecimal> num = sqlQuery.list();
        return num.get(0);
    }
    public List<Object[]> queryMostDecreaseStocks() {
        String sql = "SELECT StockName,ROUND((`Close` - `Open` )/`Close`*100,2) as Increase FROM stockprice_1day WHERE Date = '20110601' ORDER BY Increase LIMIT 5";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<Object[]> obj = sqlQuery.list();
        return obj;
    }
    public BigDecimal queryDecreaseNumber() {
        String sql = "SELECT ROUND((`Close` - `Open` )/`Close`*100,2) as Increase FROM stockprice_1day WHERE Date = '20110601' ORDER BY Increase LIMIT 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
        List<BigDecimal> num = sqlQuery.list();
        return num.get(0);
    }
}
