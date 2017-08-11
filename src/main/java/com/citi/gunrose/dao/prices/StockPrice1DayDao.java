package com.citi.gunrose.dao.prices;

import com.citi.gunrose.dao.BaseDao;
import com.citi.gunrose.persistence.model.Stockprice1Day;
import com.citi.gunrose.persistence.model.Stockprice1Min;

import java.util.List;

/**
 * Created by tangjing on 2017/8/7.
 */
public interface StockPrice1DayDao extends BaseDao<Stockprice1Day> {
    List<Object[]> selectListByStockName(String stockName, int maxSize);
}
