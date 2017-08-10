package com.citi.gunrose.dao.prices;

import com.citi.gunrose.dao.BaseDao;
import com.citi.gunrose.persistence.model.Stockprice60Min;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice60MinDao extends BaseDao<Stockprice60Min> {
    List<Object[]> selectListByStockName(String stockName, int maxSize);
}
