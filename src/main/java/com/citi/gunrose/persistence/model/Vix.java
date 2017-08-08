package com.citi.gunrose.persistence.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Vix {
    private int vixid;
    private int stockId;
    private Date date;
    private double value;
    private Stock stockByStockId;

    @Id
    @Column(name = "VIXID")
    public int getVixid() {
        return vixid;
    }

    public void setVixid(int vixid) {
        this.vixid = vixid;
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vix vix = (Vix) o;

        if (vixid != vix.vixid) return false;
        if (stockId != vix.stockId) return false;
        if (Double.compare(vix.value, value) != 0) return false;
        if (date != null ? !date.equals(vix.date) : vix.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vixid;
        result = 31 * result + stockId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
