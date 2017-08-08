package com.citi.gunrose.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Recommendedstock {
    private int id;
    private String stockGroup1;
    private String stockGroup2;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StockGroup_1")
    public String getStockGroup1() {
        return stockGroup1;
    }

    public void setStockGroup1(String stockGroup1) {
        this.stockGroup1 = stockGroup1;
    }

    @Basic
    @Column(name = "StockGroup_2")
    public String getStockGroup2() {
        return stockGroup2;
    }

    public void setStockGroup2(String stockGroup2) {
        this.stockGroup2 = stockGroup2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recommendedstock that = (Recommendedstock) o;

        if (id != that.id) return false;
        if (stockGroup1 != null ? !stockGroup1.equals(that.stockGroup1) : that.stockGroup1 != null) return false;
        if (stockGroup2 != null ? !stockGroup2.equals(that.stockGroup2) : that.stockGroup2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stockGroup1 != null ? stockGroup1.hashCode() : 0);
        result = 31 * result + (stockGroup2 != null ? stockGroup2.hashCode() : 0);
        return result;
    }
}
