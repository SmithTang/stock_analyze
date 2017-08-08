package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.Market;
import com.citi.gunrose.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tangjing on 2017/8/8.
 */
@Controller
@RequestMapping("/market")
public class MarketController {
    @Autowired
    private MarketService marketService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Market> listAll() {
        List<Market> test = marketService.getAll();
        return test;
    }
}
