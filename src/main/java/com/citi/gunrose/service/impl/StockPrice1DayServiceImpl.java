package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.StockPrice1DayDao;
import com.citi.gunrose.persistence.model.Stockprice1Day;
import com.citi.gunrose.service.StockPrice1DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
@Service("stockPrice1DayService")
@Transactional
public class StockPrice1DayServiceImpl extends BaseServiceImpl<Stockprice1Day> implements StockPrice1DayService{
    @Autowired
    private StockPrice1DayDao stockPrice1DayDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice1DayDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }
}
