package com.citi.gunrose.service.impl.prices;

import com.citi.gunrose.dao.prices.StockPrice15MinDao;
import com.citi.gunrose.persistence.model.Stockprice15Min;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.citi.gunrose.service.prices.StockPrice15MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
@Service("stockPrice15MinService")
@Transactional
public class StockPrice15MinServiceImpl extends BaseServiceImpl<Stockprice15Min> implements StockPrice15MinService {
    @Autowired
    private StockPrice15MinDao stockPrice15MinDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice15MinDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }
}
