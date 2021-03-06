package com.citi.gunrose.dao;

import com.citi.gunrose.persistence.model.Stock;

import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
public interface StockDao extends BaseDao<Stock> {
    public List<String> selectNames(int maxSize);

    public List<String> searchNames(int marketID, String term);
}
