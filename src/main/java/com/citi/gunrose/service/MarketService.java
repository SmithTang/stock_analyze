package com.citi.gunrose.service;

import com.citi.gunrose.persistence.model.Market;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
public interface MarketService extends BaseService<Market> {
    public List<Object[]> queryMostPickedStocks();
    public BigInteger queryStockNumber();
    public Integer queryVolumeNumber();
    public List<Object[]> queryMostVolumeStocks();
    public List<Object[]> queryMostIncreaseStocks();
    public BigDecimal queryIncreaseNumber();
    public List<Object[]> queryMostDecreaseStocks();
    public BigDecimal queryDecreaseNumber();
}
