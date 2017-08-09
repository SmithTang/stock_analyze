package com.citi.gunrose.service;

import com.citi.gunrose.persistence.model.Stock;

import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
public interface StockService extends BaseService<Stock> {
    public List<String> getNames();

    public List<String> searchNames(int marketID, String term);
}
