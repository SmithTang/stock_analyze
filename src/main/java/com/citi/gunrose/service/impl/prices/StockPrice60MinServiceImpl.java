package com.citi.gunrose.service.impl.prices;

import com.citi.gunrose.dao.prices.StockPrice60MinDao;
import com.citi.gunrose.persistence.model.Stockprice60Min;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.citi.gunrose.service.prices.StockPrice60MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
@Service("stockPrice60MinService")
@Transactional
public class StockPrice60MinServiceImpl extends BaseServiceImpl<Stockprice60Min> implements StockPrice60MinService {
    @Autowired
    private StockPrice60MinDao stockPrice60MinDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice60MinDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }
}
