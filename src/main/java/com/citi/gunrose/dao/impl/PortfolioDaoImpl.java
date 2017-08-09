package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.PortfolioDao;
import com.citi.gunrose.persistence.model.Portfolio;
import com.citi.gunrose.persistence.model.PortfolioList;
import com.citi.gunrose.persistence.model.Stock;
import com.citi.gunrose.persistence.model.User;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
@Repository("portfolioDao")
public class PortfolioDaoImpl extends BaseDaoImpl<Portfolio> implements PortfolioDao{
    public List<PortfolioList> queryPortfolio(User user) {

        List<PortfolioList> lists = new ArrayList<PortfolioList>();


        SQLQuery sqlQuery = this.getSession().createSQLQuery("select distinct p.PortfolioName from portfolio as p where p.UserID ="+user.getUserId());
        List<String> names = sqlQuery.list();
        for (String name:names) {

            SQLQuery sqlQuery1 = this.getSession().createSQLQuery("select * from portfolio as s where s.PortfolioName ='"+name+"'and s.UserID='"+user.getUserId()+"'");
            sqlQuery1.addEntity(Portfolio.class);
            List<Portfolio> portfolios = sqlQuery1.list();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PortfolioList portfolioList = new PortfolioList();
            portfolioList.setPortfolioName(name);
            portfolioList.setStockCount(portfolios.size());
            portfolioList.setDescription("JustForTest");
            portfolioList.setDate(df.format(new Date()));
            portfolios.clear();
            lists.add(portfolioList);
        }


        return lists;
    }

    public List<String> queryStockName(String name, User user) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select StockName from portfolio as s where s.PortfolioName ='"+name+"'and s.UserID='"+user.getUserId()+"'");
        List<String> names = sqlQuery.list();

        return names;
    }

}
