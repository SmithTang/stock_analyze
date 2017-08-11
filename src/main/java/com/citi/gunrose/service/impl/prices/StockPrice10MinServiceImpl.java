package com.citi.gunrose.service.impl.prices;

import com.citi.gunrose.dao.prices.StockPrice10MinDao;
import com.citi.gunrose.persistence.model.Stockprice10Min;
import com.citi.gunrose.service.impl.BaseServiceImpl;
import com.citi.gunrose.service.prices.StockPrice10MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjing on 2017/8/10.
 */
@Service("stockPrice10MinService")
@Transactional
public class StockPrice10MinServiceImpl extends BaseServiceImpl<Stockprice10Min> implements StockPrice10MinService {
    @Autowired
    private StockPrice10MinDao stockPrice10MinDao;

    @Override
    public List<Object[]> getListByStockName(String stockName) {
        int maxSize = 1000;
        List<Object[]> result = stockPrice10MinDao.selectListByStockName(stockName, maxSize);
        if(result == null || result.size() == 0)
            return new ArrayList<Object[]>();
        else
            return result;
    }
}
