package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.StockRela;
import com.citi.gunrose.service.StockRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tangjing on 2017/8/9.
 */
@Controller
@RequestMapping("/stockRela")
public class StockRelaController {
    @Autowired
    private StockRelaService stockRelaService;

    @RequestMapping(value = "/{stockname}", method = RequestMethod.GET)
    @ResponseBody
    public List<StockRela> get1MinRela(@PathVariable(value = "stockname")String stock1) {
        return stockRelaService.getRela(stock1);
    }
}
