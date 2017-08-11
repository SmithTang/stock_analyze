package com.citi.gunrose.dao.prices;

import com.citi.gunrose.dao.BaseDao;
import com.citi.gunrose.persistence.model.Stockprice30Min;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice30MinDao extends BaseDao<Stockprice30Min> {
    List<Object[]> selectListByStockName(String stockName, int maxSize);
}
