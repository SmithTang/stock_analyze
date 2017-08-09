package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.PortfolioDao;
import com.citi.gunrose.persistence.model.Portfolio;
import com.citi.gunrose.persistence.model.PortfolioList;
import com.citi.gunrose.persistence.model.User;
import com.citi.gunrose.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
@Service("portfolioService")
@Transactional
public class PortfolioServiceImpl extends BaseServiceImpl<Portfolio> implements PortfolioService{

    @Autowired
    private PortfolioDao portfolioDao;

    public List<PortfolioList> queryPortfolio(User user) {

        return portfolioDao.queryPortfolio(user);
    }

    public List<String> queryStockName(String name, User user) {
        return portfolioDao.queryStockName(name,user);
    }
}
