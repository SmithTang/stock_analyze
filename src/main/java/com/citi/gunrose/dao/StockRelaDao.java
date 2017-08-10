package com.citi.gunrose.dao;

import com.citi.gunrose.persistence.model.StockRela;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
public interface StockRelaDao extends BaseDao<StockRela> {
    public List<StockRela> selectRela(String stock1);
}
