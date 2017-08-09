package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/9.
 */
@Entity(name = "stock_rela")
public class StockRela {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "Stock1")
    private String stock1;

    @Basic
    @Column(name = "Stock2")
    private String stock2;

    @Basic
    @Column(name = "EndDate")
    private String endDate;

    @Basic
    @Column(name = "Days")
    private int days;

    @Basic
    @Column(name = "CCValue")
    private double CCValue;

    @ManyToOne()
    @JoinColumn(name = "Stock1", insertable = false, updatable = false)
    private Stock stock1ByStockName;

    @ManyToOne()
    @JoinColumn(name = "Stock2", insertable = false, updatable = false)
    private Stock stock2ByStockName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStock1() {
        return stock1;
    }

    public void setStock1(String stock1) {
        this.stock1 = stock1;
    }

    public String getStock2() {
        return stock2;
    }

    public void setStock2(String stock2) {
        this.stock2 = stock2;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getCCValue() {
        return CCValue;
    }

    public void setCCValue(double CCValue) {
        this.CCValue = CCValue;
    }

    public Stock getStock1ByStockName() {
        return stock1ByStockName;
    }

    public void setStock1ByStockName(Stock stock1ByStockName) {
        this.stock1ByStockName = stock1ByStockName;
    }

    public Stock getStock2ByStockName() {
        return stock2ByStockName;
    }

    public void setStock2ByStockName(Stock stock2ByStockName) {
        this.stock2ByStockName = stock2ByStockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockRela stockRela = (StockRela) o;

        if (id != stockRela.id) return false;
        if (days != stockRela.days) return false;
        if (Double.compare(stockRela.CCValue, CCValue) != 0) return false;
        if (stock1 != null ? !stock1.equals(stockRela.stock1) : stockRela.stock1 != null) return false;
        if (stock2 != null ? !stock2.equals(stockRela.stock2) : stockRela.stock2 != null) return false;
        if (endDate != null ? !endDate.equals(stockRela.endDate) : stockRela.endDate != null) return false;
        if (stock1ByStockName != null ? !stock1ByStockName.equals(stockRela.stock1ByStockName) : stockRela.stock1ByStockName != null)
            return false;
        return stock2ByStockName != null ? stock2ByStockName.equals(stockRela.stock2ByStockName) : stockRela.stock2ByStockName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (stock1 != null ? stock1.hashCode() : 0);
        result = 31 * result + (stock2 != null ? stock2.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + days;
        temp = Double.doubleToLongBits(CCValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (stock1ByStockName != null ? stock1ByStockName.hashCode() : 0);
        result = 31 * result + (stock2ByStockName != null ? stock2ByStockName.hashCode() : 0);
        return result;
    }
}
