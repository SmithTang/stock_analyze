package com.citi.gunrose.service.impl.prices;

import com.citi.gunrose.dao.prices.StockPrice30MinDao;
import com.citi.gunrose.persistence.model.Stockprice30Min;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.citi.gunrose.service.prices.StockPrice30MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
@Service("stockPrice30MinService")
@Transactional
public class StockPrice30MinServiceImpl extends BaseServiceImpl<Stockprice30Min> implements StockPrice30MinService {
    @Autowired
    private StockPrice30MinDao stockPrice30MinDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice30MinDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }
}
