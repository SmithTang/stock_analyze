package com.citi.gunrose.service.impl;

import com.citi.gunrose.persistence.model.Market;
import com.citi.gunrose.service.MarketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangjing on 2017/8/8.
 */
@Service("marketService")
@Transactional
public class MarketServiceImpl extends BaseServiceImpl<Market> implements MarketService {
}
