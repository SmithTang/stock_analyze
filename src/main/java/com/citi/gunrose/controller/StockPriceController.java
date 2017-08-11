package com.citi.gunrose.controller;

import com.citi.gunrose.service.prices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
@Controller
@RequestMapping(value = "/stockprice")
public class StockPriceController {
    @Autowired
    private StockPrice1MinService stockPrice1MinService;

    @Autowired
    private StockPrice1DayService stockPrice1DayService;

    @Autowired
    private StockPrice5MinService stockPrice5MinService;

    @Autowired
    private StockPrice10MinService stockPrice10MinService;

    @Autowired
    private StockPrice15MinService stockPrice15MinService;

    @Autowired
    private StockPrice30MinService stockPrice30MinService;

    @Autowired
    private StockPrice60MinService stockPrice60MinService;

    @RequestMapping(value = "/1min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get1MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice1MinService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/1day/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get1DayPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice1DayService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/5min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get5MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice5MinService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/5min/{stockname}/{fakeTime}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get5MinPriceByStockName(@PathVariable("stockname") String stockName,
                                                  @PathVariable(value = "fakeTime") String fakeTime) {
        return stockPrice5MinService.getListByStockNameBetweenFakeTime(stockName, fakeTime);
    }

    @RequestMapping(value = "/10min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get10MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice10MinService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/15min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get15MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice15MinService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/30min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get30MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice30MinService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/60min/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> get60MinPriceByStockName(@PathVariable("stockname") String stockName) {
        return stockPrice60MinService.getListByStockName(stockName);
    }

    @RequestMapping(value = "/fakeTime/{fakeTime}", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> fakeTime(@PathVariable("fakeTime") String fakeTime) {
        return stockPrice5MinService.getListByFakeTime(fakeTime);
    }

    @RequestMapping(value = "/singleStock", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> singleStock(@RequestParam(value = "singleStock", required = true) String stockName,
                                      @RequestParam(value = "fakeTime", required = true) String fakeTime) {
        return stockPrice5MinService.getByStockNameAndFakeTime(stockName, fakeTime);
    }

}
