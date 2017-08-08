package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PortfolioID")
    private int portfolioId;

    @Basic
    @Column(name = "PortfolioName")
    private String portfolioName;

    @Basic
    @Column(name = "UserID")
    private int userId;

    @Basic
    @Column(name = "StockName")
    private String stockName;

    @ManyToOne()
    @JoinColumn(name = "UserID", insertable = false, updatable = false)
    private User userByUserId;

    @ManyToOne()
    @JoinColumn(name = "StockName", insertable = false, updatable = false)
    private Stock stockByStockName;

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Stock getStockByStockName() {
        return stockByStockName;
    }

    public void setStockByStockName(Stock stockByStockName) {
        this.stockByStockName = stockByStockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Portfolio portfolio = (Portfolio) o;

        if (portfolioId != portfolio.portfolioId) return false;
        if (userId != portfolio.userId) return false;
        if (portfolioName != null ? !portfolioName.equals(portfolio.portfolioName) : portfolio.portfolioName != null)
            return false;
        if (stockName != null ? !stockName.equals(portfolio.stockName) : portfolio.stockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = portfolioId;
        result = 31 * result + (portfolioName != null ? portfolioName.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        return result;
    }

}
