package com.citi.gunrose.dao;

import com.citi.gunrose.persistence.model.Portfolio;
import com.citi.gunrose.persistence.model.PortfolioList;
import com.citi.gunrose.persistence.model.User;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
public interface PortfolioDao extends BaseDao<Portfolio>{
    public List<PortfolioList> queryPortfolio(User user);
    public List<String> queryStockName(String name, User user);
}
