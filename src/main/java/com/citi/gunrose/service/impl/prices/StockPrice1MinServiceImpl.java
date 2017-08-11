package com.citi.gunrose.service.impl.prices;

import com.citi.gunrose.dao.prices.StockPrice1MinDao;
import com.citi.gunrose.persistence.model.Stockprice1Min;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.citi.gunrose.service.prices.StockPrice1MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/7.
 */
@Service("stockPrice1MinService")
@Transactional
public class StockPrice1MinServiceImpl extends BaseServiceImpl<Stockprice1Min> implements StockPrice1MinService {
    @Autowired
    private StockPrice1MinDao stockPrice1MinDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice1MinDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }
}
