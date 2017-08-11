package com.citi.gunrose.dao.prices;

import com.citi.gunrose.dao.BaseDao;
import com.citi.gunrose.persistence.model.Stockprice15Min;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice15MinDao extends BaseDao<Stockprice15Min> {
    List<Object[]> selectListByStockName(String stockName, int maxSize);
}
