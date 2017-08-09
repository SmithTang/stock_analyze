package com.citi.gunrose.controller;

import com.citi.gunrose.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by tangjing on 2017/8/9.
 */
@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public List<String> listAllNames() {
        return stockService.getNames();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchName(@RequestParam(value = "market", required = true) Integer marketID,
                                   @RequestParam(value = "q", required = true) String searchTerm,
                                   @RequestParam(value = "page", required = false) Integer page) {
        List<String> names = stockService.searchNames(marketID, searchTerm);
        List<Map> namesAndIDs = new ArrayList<Map>(names.size());
        Map<String, Object> result = new HashMap(names.size());
        for(String name : names) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("id", name);
            obj.put("text", name);
            namesAndIDs.add(obj);
        }
        result.put("items", namesAndIDs);
        result.put("total_count", names.size());
        return result;
    }
}
