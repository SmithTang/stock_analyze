package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice15Min;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice15MinService extends BaseService<Stockprice15Min> {
    List<Object[]> getListByStockName(String stockName);
}
