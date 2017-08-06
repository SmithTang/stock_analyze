package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.StockDao;
import com.citi.gunrose.persistence.model.Stock;
import com.citi.gunrose.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangjing on 2017/8/6.
 */
@Service("stockService")
@Transactional
public class StockServiveImpl extends BaseServiceImpl<Stock> implements StockService {
    @Autowired
    private StockDao stockDao;
}
