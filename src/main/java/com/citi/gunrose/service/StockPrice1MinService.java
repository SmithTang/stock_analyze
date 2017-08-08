package com.citi.gunrose.service;

import com.citi.gunrose.persistence.model.Stockprice1Min;

import java.util.List;

/**
 * Created by tangjing on 2017/8/7.
 */
public interface StockPrice1MinService extends BaseService<Stockprice1Min> {

    List<Object[]> selectListByStockName(String stockName);

}
