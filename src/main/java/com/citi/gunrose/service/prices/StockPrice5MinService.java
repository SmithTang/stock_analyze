package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice5Min;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice5MinService extends BaseService<Stockprice5Min> {
    List<Object[]> getListByStockName(String stockName);
}
