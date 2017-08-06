package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.StockDao;
import com.citi.gunrose.persistence.model.Stock;
import org.springframework.stereotype.Repository;

/**
 * Created by tangjing on 2017/8/6.
 */
@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {
}
