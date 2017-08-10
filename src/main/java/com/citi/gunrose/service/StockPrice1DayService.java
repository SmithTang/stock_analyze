package com.citi.gunrose.service;

import com.citi.gunrose.persistence.model.Stockprice1Day;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
public interface StockPrice1DayService extends BaseService<Stockprice1Day> {
    public List<Object[]> getListByStockName(String stockName);
}
