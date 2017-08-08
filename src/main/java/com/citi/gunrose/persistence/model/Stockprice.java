package com.citi.gunrose.persistence.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Stockprice {
    private int id;
    private int timeTypeId;
    private int stockId;
    private String date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private int volume;
    private Timetype timetypeByTimeTypeId;
    private Stock stockByStockId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TimeTypeID")
    public int getTimeTypeId() {
        return timeTypeId;
    }

    public void setTimeTypeId(int timeTypeId) {
        this.timeTypeId = timeTypeId;
    }

    @Basic
    @Column(name = "StockID")
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Open")
    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    @Basic
    @Column(name = "High")
    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    @Basic
    @Column(name = "Low")
    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    @Basic
    @Column(name = "Close")
    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    @Basic
    @Column(name = "Volume")
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stockprice that = (Stockprice) o;

        if (id != that.id) return false;
        if (timeTypeId != that.timeTypeId) return false;
        if (stockId != that.stockId) return false;
        if (volume != that.volume) return false;
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
        result = 31 * result + timeTypeId;
        result = 31 * result + stockId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (close != null ? close.hashCode() : 0);
        result = 31 * result + volume;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TimeTypeID", referencedColumnName = "TypeID", nullable = false)
    public Timetype getTimetypeByTimeTypeId() {
        return timetypeByTimeTypeId;
    }

    public void setTimetypeByTimeTypeId(Timetype timetypeByTimeTypeId) {
        this.timetypeByTimeTypeId = timetypeByTimeTypeId;
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
