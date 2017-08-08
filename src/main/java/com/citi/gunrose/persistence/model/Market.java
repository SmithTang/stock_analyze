package com.citi.gunrose.persistence.model;

import javax.persistence.*;

/**
 * Created by tangjing on 2017/8/8.
 */
@Entity
public class Market {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MarketID")
    private int marketId;

    @Basic
    @Column(name = "MarketName")
    private String marketName;

    @Basic
    @Column(name = "Location")
    private String location;

    @Basic
    @Column(name = "Currency")
    private String currency;

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Market market = (Market) o;

        if (marketId != market.marketId) return false;
        if (marketName != null ? !marketName.equals(market.marketName) : market.marketName != null) return false;
        if (location != null ? !location.equals(market.location) : market.location != null) return false;
        if (currency != null ? !currency.equals(market.currency) : market.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = marketId;
        result = 31 * result + (marketName != null ? marketName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
