package com.citi.gunrose.service;

import com.citi.gunrose.persistence.model.StockRela;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.fasterxml.jackson.databind.deser.Deserializers;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
public interface StockRelaService extends BaseService<StockRela> {
    public List<StockRela> getRela(String stock1);
}
