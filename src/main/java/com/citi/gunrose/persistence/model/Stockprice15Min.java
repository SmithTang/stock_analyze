package com.citi.gunrose.persistence.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity(name = "stockprice_15min")
public class Stockprice15Min {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "StockName")
    private String stockName;

    @Basic
    @Column(name = "Date")
    private String date;

    @Basic
    @Column(name = "Open")
    private BigDecimal open;

    @Basic
    @Column(name = "High")
    private BigDecimal high;

    @Basic
    @Column(name = "Low")
    private BigDecimal low;

    @Basic
    @Column(name = "Close")
    private BigDecimal close;

    @Basic
    @Column(name = "Volume")
    private int volume;

    @ManyToOne()
    @JoinColumn(name = "StockName", insertable = false, updatable = false)
    private Stock stockByStockName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

        Stockprice15Min that = (Stockprice15Min) o;

        if (id != that.id) return false;
        if (volume != that.volume) return false;
        if (stockName != null ? !stockName.equals(that.stockName) : that.stockName != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (open != null ? !open.equals(that.open) : that.open != null) return false;
        if (high != null ? !high.equals(that.high) : that.high != null) return false;
        if (low != null ? !low.equals(that.low) : that.low != null) return false;
        if (close != null ? !close.equals(that.close) : that.close != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (close != null ? close.hashCode() : 0);
        result = 31 * result + volume;
        return result;
    }

 }
