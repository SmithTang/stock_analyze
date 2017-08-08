package com.citi.gunrose.persistence.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity(name = "vix")
public class Vix {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "VIXID")
    private int vixid;

    @Basic
    @Column(name = "StockName")
    private String stockName;

    @Basic
    @Column(name = "Date")
    private Date date;

    @Basic
    @Column(name = "Value")
    private float value;

    @ManyToOne()
    @JoinColumn(name = "StockName", insertable = false, updatable = false)
    private Stock stockByStockName;

    public int getVixid() {
        return vixid;
    }

    public void setVixid(int vixid) {
        this.vixid = vixid;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
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

        Vix vix = (Vix) o;

        if (vixid != vix.vixid) return false;
        if (Float.compare(vix.value, value) != 0) return false;
        if (stockName != null ? !stockName.equals(vix.stockName) : vix.stockName != null) return false;
        if (date != null ? !date.equals(vix.date) : vix.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vixid;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (value != +0.0f ? Float.floatToIntBits(value) : 0);
        return result;
    }

}
