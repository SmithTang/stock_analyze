package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Portfolio {
    private int portfolioId;
    private String portfolioName;
    private int userId;
    private int stockId;
    private User userByUserId;
    private Stock stockByStockId;

    @Id
    @Column(name = "PortfolioID")
    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Basic
    @Column(name = "PortfolioName")
    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    @Basic
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "StockID")
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Portfolio portfolio = (Portfolio) o;

        if (portfolioId != portfolio.portfolioId) return false;
        if (userId != portfolio.userId) return false;
        if (stockId != portfolio.stockId) return false;
        if (portfolioName != null ? !portfolioName.equals(portfolio.portfolioName) : portfolio.portfolioName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = portfolioId;
        result = 31 * result + (portfolioName != null ? portfolioName.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + stockId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "StockID", referencedColumnName = "StockID", nullable = false)
    public Stock getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
    }
}
