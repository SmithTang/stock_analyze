package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice30Min;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice30MinService extends BaseService<Stockprice30Min> {
    List<Object[]> getListByStockName(String stockName);
}
