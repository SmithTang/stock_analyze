package com.citi.gunrose.service.impl;

import com.citi.gunrose.persistence.model.Stockprice;
import com.citi.gunrose.service.StockPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangjing on 2017/8/7.
 */
@Service("stockPriceService")
@Transactional
public class StockPriceServiceImpl extends BaseServiceImpl<Stockprice> implements StockPriceService {
}
