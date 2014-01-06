package com.racket.commons.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.baldy.commons.models.Rentable;

@Entity
@Table(name = RacketRentable.table)
public class RacketRentable implements Rentable {

    public static final String table = "rentable";

    @Id
    @GeneratedValue
    private long id;
    
    @Column
    private String name;
    
    @Column
    private String description;
    
    @Column
    private String unit;
    
    @Column
    private BigDecimal pricePerUnit;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
