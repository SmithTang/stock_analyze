package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.Stockprice1Min;
import com.citi.gunrose.service.StockPrice1MinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
@Controller
@RequestMapping(value = "/stockprice")
public class StockPriceController {
    @Autowired
    private StockPrice1MinService stockPrice1MinService;

    @RequestMapping(value = "/1min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get1MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice1MinService.selectListByStockName(stockName);
    }

}
