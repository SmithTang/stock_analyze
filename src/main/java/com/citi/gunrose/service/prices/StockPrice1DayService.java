package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice1Day;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
public interface StockPrice1DayService extends BaseService<Stockprice1Day> {
    public List<Object[]> getListByStockName(String stockName);
}
