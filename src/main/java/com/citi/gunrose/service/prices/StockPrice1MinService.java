package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice1Min;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/7.
 */
public interface StockPrice1MinService extends BaseService<Stockprice1Min> {

    List<Object[]> getListByStockName(String stockName);

}
