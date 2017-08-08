package com.citi.gunrose.persistence.model;

import com.citi.gunrose.persistence.model.Market;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity(name = "stock")
public class Stock {
    @Basic
    @Column(name = "MarkID")
    private int markId;

    @Id
    @Column(name = "StockName")
    private String stockName;

    @ManyToOne()
    @JoinColumn(name = "MarkID", insertable = false, updatable = false)
    private Market stockByStockName;

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Market getStockByStockName() {
        return stockByStockName;
    }

    public void setStockByStockName(Market stockByStockName) {
        this.stockByStockName = stockByStockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (markId != stock.markId) return false;
        if (stockName != null ? !stockName.equals(stock.stockName) : stock.stockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = markId;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        return result;
    }
}
