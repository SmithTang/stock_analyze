package com.citi.gunrose.persistence.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Stock {
    private int stockId;
    private int marketId;
    private String stockName;
    private String description;
    private Integer symbol;
    private int id;
    private String isin;
    private Collection<Highrelatedstocks> highrelatedstockssByStockId;
    private Collection<Highrelatedstocks> highrelatedstockssByStockId_0;
    private Collection<Lowrelatedstocks> lowrelatedstockssByStockId;
    private Collection<Lowrelatedstocks> lowrelatedstockssByStockId_0;
    private Collection<Portfolio> portfoliosByStockId;
    private Collection<Stockprice> stockpricesByStockId;
    private Collection<Vix> vixesByStockId;

    @Id
    @Column(name = "StockID")
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "MarketID")
    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    @Basic
    @Column(name = "StockName")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Symbol")
    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ISIN")
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (stockId != stock.stockId) return false;
        if (marketId != stock.marketId) return false;
        if (id != stock.id) return false;
        if (stockName != null ? !stockName.equals(stock.stockName) : stock.stockName != null) return false;
        if (description != null ? !description.equals(stock.description) : stock.description != null) return false;
        if (symbol != null ? !symbol.equals(stock.symbol) : stock.symbol != null) return false;
        if (isin != null ? !isin.equals(stock.isin) : stock.isin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + marketId;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (isin != null ? isin.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stockByStockId1")
    public Collection<Highrelatedstocks> getHighrelatedstockssByStockId() {
        return highrelatedstockssByStockId;
    }

    public void setHighrelatedstockssByStockId(Collection<Highrelatedstocks> highrelatedstockssByStockId) {
        this.highrelatedstockssByStockId = highrelatedstockssByStockId;
    }

    @OneToMany(mappedBy = "stockByStockId2")
    public Collection<Highrelatedstocks> getHighrelatedstockssByStockId_0() {
        return highrelatedstockssByStockId_0;
    }

    public void setHighrelatedstockssByStockId_0(Collection<Highrelatedstocks> highrelatedstockssByStockId_0) {
        this.highrelatedstockssByStockId_0 = highrelatedstockssByStockId_0;
    }

    @OneToMany(mappedBy = "stockByStockId1")
    public Collection<Lowrelatedstocks> getLowrelatedstockssByStockId() {
        return lowrelatedstockssByStockId;
    }

    public void setLowrelatedstockssByStockId(Collection<Lowrelatedstocks> lowrelatedstockssByStockId) {
        this.lowrelatedstockssByStockId = lowrelatedstockssByStockId;
    }

    @OneToMany(mappedBy = "stockByStockId2")
    public Collection<Lowrelatedstocks> getLowrelatedstockssByStockId_0() {
        return lowrelatedstockssByStockId_0;
    }

    public void setLowrelatedstockssByStockId_0(Collection<Lowrelatedstocks> lowrelatedstockssByStockId_0) {
        this.lowrelatedstockssByStockId_0 = lowrelatedstockssByStockId_0;
    }

    @OneToMany(mappedBy = "stockByStockId")
    public Collection<Portfolio> getPortfoliosByStockId() {
        return portfoliosByStockId;
    }

    public void setPortfoliosByStockId(Collection<Portfolio> portfoliosByStockId) {
        this.portfoliosByStockId = portfoliosByStockId;
    }

    @OneToMany(mappedBy = "stockByStockId")
    public Collection<Stockprice> getStockpricesByStockId() {
        return stockpricesByStockId;
    }

    public void setStockpricesByStockId(Collection<Stockprice> stockpricesByStockId) {
        this.stockpricesByStockId = stockpricesByStockId;
    }

    @OneToMany(mappedBy = "stockByStockId")
    public Collection<Vix> getVixesByStockId() {
        return vixesByStockId;
    }

    public void setVixesByStockId(Collection<Vix> vixesByStockId) {
        this.vixesByStockId = vixesByStockId;
    }
}
