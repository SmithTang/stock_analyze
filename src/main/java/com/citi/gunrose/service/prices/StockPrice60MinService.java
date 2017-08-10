package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice60Min;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice60MinService extends BaseService<Stockprice60Min> {
    List<Object[]> getListByStockName(String stockName);
}
