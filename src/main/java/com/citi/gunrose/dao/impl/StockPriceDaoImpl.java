package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.StockPriceDao;
import com.citi.gunrose.persistence.model.Stockprice1Min;
import org.springframework.stereotype.Repository;

/**
 * Created by tangjing on 2017/8/7.
 */
@Repository("stockPriceDao")
public class StockPriceDaoImpl extends BaseDaoImpl<Stockprice1Min> implements StockPriceDao {
}
