package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.MarketDao;
import com.citi.gunrose.persistence.model.Market;
import org.springframework.stereotype.Repository;

/**
 * Created by tangjing on 2017/8/8.
 */
@Repository("marketDao")
public class MarketDaoImpl extends BaseDaoImpl<Market> implements MarketDao {
}
