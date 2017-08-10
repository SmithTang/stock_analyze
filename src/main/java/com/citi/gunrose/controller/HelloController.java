package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.Stock;
import com.citi.gunrose.service.MarketService;
import com.citi.gunrose.service.PortfolioService;
import com.citi.gunrose.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
@Controller
public class HelloController {

    @Autowired
    private StockService stockService;
    @Autowired
    private MarketService marketService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Stock hello() {
        Stock test = stockService.getById(1);
        return test;
    }

    @RequestMapping(value = "/singlestock", method = RequestMethod.GET)
    public String singleStock() {

        return "singlestock";
    }
    @RequestMapping(value = "/market", method = RequestMethod.GET)
    public String Market(HttpServletRequest request, HttpSession httpSession) {
        List<Object[]> pickobj = marketService.queryMostPickedStocks();
        int picknum = marketService.queryStockNumber().intValue();
        request.setAttribute("pickobj",pickobj);
        request.setAttribute("picknum",picknum);

        List<Object[]> volumeobj = marketService.queryMostVolumeStocks();
        int volumenum = marketService.queryVolumeNumber().intValue();
        request.setAttribute("volumeobj",volumeobj);
        request.setAttribute("volumenum",volumenum);

        List<Object[]> increaseobj = marketService.queryMostIncreaseStocks();
        Double increasenum = marketService.queryIncreaseNumber().doubleValue();
        request.setAttribute("increaseobj",increaseobj);
        request.setAttribute("increasenum",increasenum);

        List<Object[]> decreaseobj = marketService.queryMostDecreaseStocks();
        Double decreasenum = marketService.queryDecreaseNumber().doubleValue();
        request.setAttribute("decreaseobj",decreaseobj);
        request.setAttribute("decreasenum",decreasenum);

        return "market";
    }
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String Export() {
        return "export";
    }
}
//    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String MyPortfolioList() {
//        return "stock";
//    }

