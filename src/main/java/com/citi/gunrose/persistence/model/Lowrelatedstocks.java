package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Lowrelatedstocks {
    private int id;
    private int stockId1;
    private int stockId2;
    private Stock stockByStockId1;
    private Stock stockByStockId2;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StockID_1")
    public int getStockId1() {
        return stockId1;
    }

    public void setStockId1(int stockId1) {
        this.stockId1 = stockId1;
    }

    @Basic
    @Column(name = "StockID_2")
    public int getStockId2() {
        return stockId2;
    }

    public void setStockId2(int stockId2) {
        this.stockId2 = stockId2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lowrelatedstocks that = (Lowrelatedstocks) o;

        if (id != that.id) return false;
        if (stockId1 != that.stockId1) return false;
        if (stockId2 != that.stockId2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + stockId1;
        result = 31 * result + stockId2;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StockID_1", referencedColumnName = "StockID", nullable = false)
    public Stock getStockByStockId1() {
        return stockByStockId1;
    }

    public void setStockByStockId1(Stock stockByStockId1) {
        this.stockByStockId1 = stockByStockId1;
    }

    @ManyToOne
    @JoinColumn(name = "StockID_2", referencedColumnName = "StockID", nullable = false)
    public Stock getStockByStockId2() {
        return stockByStockId2;
    }

    public void setStockByStockId2(Stock stockByStockId2) {
        this.stockByStockId2 = stockByStockId2;
    }
}
