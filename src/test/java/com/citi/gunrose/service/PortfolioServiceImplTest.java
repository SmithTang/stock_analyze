package com.citi.gunrose.service;

import com.citi.gunrose.dao.PortfolioDao;
import com.citi.gunrose.persistence.model.PortfolioList;
import com.citi.gunrose.persistence.model.User;
import com.citi.gunrose.service.impl.PortfolioServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by miaochangfu on 2017/8/10.
 */
public class PortfolioServiceImplTest {
    @InjectMocks
    private PortfolioServiceImpl portfolioService = new PortfolioServiceImpl();

    @Mock(name = "portfolioDao")
    private PortfolioDao portfolioDao;

    @Before
    public void  setUp() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void testQueryPortfolio() {
        List<PortfolioList> list = new ArrayList<PortfolioList>();

        User user = new User();
        user.setUserId(1);
        user.setEmail("wq");
        user.setPassword("ppp");
        user.setUserName("name");
        PortfolioList plist = new PortfolioList();
        plist.setStockCount(12);

        list.add(plist);
        when(portfolioDao.queryPortfolio(Mockito.any(User.class))).thenReturn(list);

        List<PortfolioList> lists = portfolioDao.queryPortfolio(user);
        Assert.assertNotNull(lists);

    }

    @Test
    public void testQueryStockName() {

        List<String> t = new ArrayList<String>();
        String s = "Richard";
        t.add(s);
        when(portfolioDao.queryStockName(Mockito.anyString(),Mockito.any(User.class))).thenReturn(t);

        User user = new User();
        user.setUserName("Ric");
        List<String> strings = portfolioDao.queryStockName("Richard", user);
        Assert.assertEquals("Richard", strings.get(0));
    }

}
