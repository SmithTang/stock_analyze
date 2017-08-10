package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.Stockprice1Min;
import com.citi.gunrose.service.prices.StockPrice1MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tangjing on 2017/8/7.
 */
@Controller
public class DemoController {

    @Autowired
    private StockPrice1MinService stockPrice1MinService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() {
        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public Stockprice1Min data() {
        Stockprice1Min stockprice = stockPrice1MinService.getById(1);

        return stockprice;
    }

}
