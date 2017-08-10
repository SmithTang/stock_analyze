package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.MarketDao;
import com.citi.gunrose.persistence.model.Market;
import com.citi.gunrose.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
@Service("marketService")
@Transactional
public class MarketServiceImpl extends BaseServiceImpl<Market> implements MarketService {
    @Autowired
    private MarketDao marketDao;
    public List<Object[]> queryMostPickedStocks() {

        return marketDao.queryMostPickedStocks();
    }
    public BigInteger queryStockNumber(){
        return marketDao.queryStockNumber();
    }
    public Integer queryVolumeNumber(){
        return marketDao.queryVolumeNumber();
    }
    public List<Object[]> queryMostVolumeStocks(){
        return marketDao.queryMostVolumeStocks();
    }
    public List<Object[]> queryMostIncreaseStocks(){
        return marketDao.queryMostIncreaseStocks();
    }
    public BigDecimal queryIncreaseNumber(){
        return marketDao.queryIncreaseNumber();
    }
    public List<Object[]> queryMostDecreaseStocks(){
        return marketDao.queryMostDecreaseStocks();
    }
    public BigDecimal queryDecreaseNumber(){
        return marketDao.queryDecreaseNumber();
    }

}
