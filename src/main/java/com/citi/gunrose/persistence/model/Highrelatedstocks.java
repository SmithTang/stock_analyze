package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity(name = "highrelatedstocks")
public class Highrelatedstocks {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "StockName_1")
    private String stockName1;

    @Basic
    @Column(name = "StockName_2")
    private String stockName2;

    @ManyToOne()
    @JoinColumn(name = "StockName", insertable = false, updatable = false)
    private Stock stockByStockName1;

    @ManyToOne()
    @JoinColumn(name = "StockName", insertable = false, updatable = false)
    private Stock stockByStockName2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockName1() {
        return stockName1;
    }

    public void setStockName1(String stockName1) {
        this.stockName1 = stockName1;
    }

    public String getStockName2() {
        return stockName2;
    }

    public void setStockName2(String stockName2) {
        this.stockName2 = stockName2;
    }

    public Stock getStockByStockName1() {
        return stockByStockName1;
    }

    public void setStockByStockName1(Stock stockByStockName1) {
        this.stockByStockName1 = stockByStockName1;
    }

    public Stock getStockByStockName2() {
        return stockByStockName2;
    }

    public void setStockByStockName2(Stock stockByStockName2) {
        this.stockByStockName2 = stockByStockName2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Highrelatedstocks that = (Highrelatedstocks) o;

        if (id != that.id) return false;
        if (stockName1 != null ? !stockName1.equals(that.stockName1) : that.stockName1 != null) return false;
        if (stockName2 != null ? !stockName2.equals(that.stockName2) : that.stockName2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stockName1 != null ? stockName1.hashCode() : 0);
        result = 31 * result + (stockName2 != null ? stockName2.hashCode() : 0);
        return result;
    }

}
