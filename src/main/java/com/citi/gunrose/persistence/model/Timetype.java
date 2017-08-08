package com.citi.gunrose.persistence.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Timetype {
    private int typeId;
    private String description;
    private String type;
    private Collection<Stockprice> stockpricesByTypeId;

    @Id
    @Column(name = "TypeID")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timetype timetype = (Timetype) o;

        if (typeId != timetype.typeId) return false;
        if (description != null ? !description.equals(timetype.description) : timetype.description != null)
            return false;
        if (type != null ? !type.equals(timetype.type) : timetype.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "timetypeByTimeTypeId")
    public Collection<Stockprice> getStockpricesByTypeId() {
        return stockpricesByTypeId;
    }

    public void setStockpricesByTypeId(Collection<Stockprice> stockpricesByTypeId) {
        this.stockpricesByTypeId = stockpricesByTypeId;
    }
}
