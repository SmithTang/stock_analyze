package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.Stock;
import com.citi.gunrose.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by tangjing on 2017/8/6.
 */
@Controller
public class HelloController {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("main");
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
//    @RequestMapping(value = "/Stock", method = RequestMethod.GET)
//    public String Stock() {
//        return "stock";
//    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String MyPortfolioList() {
//        return "stock";
//    }
}
