package com.citi.gunrose.dao;

import com.citi.gunrose.persistence.model.Market;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
public interface MarketDao extends BaseDao<Market> {

    public List<Object[]> queryMostPickedStocks();
    public BigInteger queryStockNumber();
    public List<Object[]> queryMostVolumeStocks();
    public Integer queryVolumeNumber();
    public List<Object[]> queryMostIncreaseStocks();
    public BigDecimal queryIncreaseNumber();
    public List<Object[]> queryMostDecreaseStocks();
    public BigDecimal queryDecreaseNumber();
}
