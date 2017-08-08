package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity(name = "recommendedstock")
public class Recommendedstock {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "StockGroup_1")
    private String stockGroup1;

    @Basic
    @Column(name = "StockGroup_2")
    private String stockGroup2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockGroup1() {
        return stockGroup1;
    }

    public void setStockGroup1(String stockGroup1) {
        this.stockGroup1 = stockGroup1;
    }

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
