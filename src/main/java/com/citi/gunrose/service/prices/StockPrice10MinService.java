package com.citi.gunrose.service.prices;

import com.citi.gunrose.persistence.model.Stockprice10Min;
import com.citi.gunrose.persistence.model.Stockprice5Min;
import com.citi.gunrose.service.BaseService;

import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
public interface StockPrice10MinService extends BaseService<Stockprice10Min> {
    List<Object[]> getListByStockName(String stockName);
}
