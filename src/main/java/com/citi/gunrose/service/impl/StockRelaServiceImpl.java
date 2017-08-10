package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.StockRelaDao;
import com.citi.gunrose.persistence.model.StockRela;
import com.citi.gunrose.service.StockRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
@Service("stockRelaService")
@Transactional
public class StockRelaServiceImpl extends BaseServiceImpl<StockRela> implements StockRelaService {
    @Autowired
    private StockRelaDao stockRelaDao;

    @Override
    public List<StockRela> getRela(String stock1) {
        return stockRelaDao.selectRela(stock1);
    }
}
