package com.citi.gunrose.dao.prices;

import com.citi.gunrose.dao.BaseDao;
import com.citi.gunrose.persistence.model.Stockprice5Min;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice5MinDao extends BaseDao<Stockprice5Min> {
    List<Object[]> selectListByStockName(String stockName, int maxSize);
}
