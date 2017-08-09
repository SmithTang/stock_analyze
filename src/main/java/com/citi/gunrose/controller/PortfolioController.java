package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.*;
import com.citi.gunrose.service.PortfolioService;
import com.citi.gunrose.service.StockService;
import com.citi.gunrose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by miaochangfu on 2017/8/8.
 */
@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private UserService userService;
    @Autowired
    private StockService stockService;

    @RequestMapping("addPortfolio")
    public String addPortfolio() {
        return "/addportfolio";
    }

    @RequestMapping("toAddPortfolio")
   // public String toAddPortfolio(@ModelAttribute("portfolio") Portfolio portfolio, RedirectAttributes attr) {
    public String toAddPortfolio(HttpServletRequest request, HttpSession httpSession){
        Portfolio portfolio = new Portfolio();
        User user1 = (User)httpSession.getAttribute("loginUser");

        //User user = userService.getById(Integer.parseInt(request.getParameter("UserID")));
        Stock stock = stockService.getById(request.getParameter("StockName"));
        portfolio.setPortfolioName(request.getParameter("PortfolioName"));
        portfolio.setStockName(request.getParameter("StockName"));
        //portfolio.setUserId(Integer.parseInt(request.getParameter("UserID")));
        portfolio.setUserId(user1.getUserId());
        System.out.print(user1.getUserId());
        portfolio.setStockByStockName(stock);
        portfolio.setUserByUserId(user1);
        //portfolio.setUserByUserId(user);

        portfolioService.save(portfolio);
        return "redirect:/list";
    }

    @RequestMapping("portfolioList")
    public String portfolioList() {
        return "/portfolioList";
    }

    @RequestMapping("list1")
    public String listAll(HttpServletRequest request, HttpSession httpSession) {

        User user = (User)httpSession.getAttribute("loginUser");
        List<PortfolioList> portfolioList = portfolioService.queryPortfolio(user);
        request.setAttribute("portfolioList",portfolioList);
        //return "";
        return "/portfolioList";
    }

    @RequestMapping("queryPortfolio")
    public String queryPortfolio(String name,HttpSession httpSession, Map<String,Object> model) {

        List<Stock> stock  = new ArrayList<Stock>();
        User user = (User)httpSession.getAttribute("loginUser");
        List<String> stockList = portfolioService.queryStockName(name,user);
        for (String stockname: stockList) {
            stock.add(stockService.getById(stockname));
        }
       model.put("stock",stock);
        //return "";
        return "/singleportfolio";
    }

    @RequestMapping("list")
    public String listAll(Map<String,Object> model, HttpSession httpSession) {

        User user = (User)httpSession.getAttribute("loginUser");
        List<PortfolioList> portfolioList = portfolioService.queryPortfolio(user);
        model.put("portfolioList", portfolioList);
        //return "";
        return "/portfolioList";
    }


    @RequestMapping("searchStock")
    public String searchStock(@ModelAttribute("portfolio") Portfolio portfolio, RedirectAttributes attr) {

        portfolioService.save(portfolio);
        attr.addFlashAttribute(portfolio);
        return "/listAll";
    }



//    @RequestMapping("listAll")
//    public String listAll(Map<String,Object> model) {
//        String hql = "from Portfolio as p where p.PortfolioName=:name ";
//        portfolioService.getByHQL(hql,)
//        List<Portfolio> portfolioList = portfolioService
//                testService.caseList();
//        model.put("caseList", caseList);
//        //return "caseList";
//        return "table";
//    }
    @RequestMapping("listAll")
    public String findAllCourse(HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            String pageNo = request.getParameter("pageNo");
            String hql = "from Portfolio as p where p.PortfolioName=:name ";
            String PortfolioName = request.getParameter("PortfolioName");
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = portfolioService.queryForPage(Integer.valueOf(pageNo), 10, hql, PortfolioName);
            request.setAttribute("page", page);
            List<Portfolio> portfolios = page.getList();
            request.setAttribute("portfolios", portfolios);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/portfoliolist";
    }
}
