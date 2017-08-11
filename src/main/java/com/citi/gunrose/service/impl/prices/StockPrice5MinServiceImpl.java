package com.citi.gunrose.service.impl.prices;

import com.citi.gunrose.dao.prices.StockPrice5MinDao;
import com.citi.gunrose.persistence.model.Stockprice5Min;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.citi.gunrose.service.prices.StockPrice5MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
@Service("stockPrice5MinService")
@Transactional
public class StockPrice5MinServiceImpl extends BaseServiceImpl<Stockprice5Min> implements StockPrice5MinService {
    @Autowired
    private StockPrice5MinDao stockPrice5MinDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice5MinDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }

    @Override
    public List<Object[]> getListByFakeTime(String fakeTime) {
        int maxSize = 20;
        return stockPrice5MinDao.selectListByFakeTime(fakeTime, maxSize);
    }

    @Override
    public List<Object[]> getByStockNameAndFakeTime(String stockName, String fakeTime) {
        return stockPrice5MinDao.selectByStockNameAndFakeTime(stockName, fakeTime);
    }

    @Override
    public List<Object[]> getListByStockNameBetweenFakeTime(String stockName, String fakeTime) {
        return stockPrice5MinDao.selectByStockNameBetweenFakeTime(stockName, fakeTime);
    }
}
