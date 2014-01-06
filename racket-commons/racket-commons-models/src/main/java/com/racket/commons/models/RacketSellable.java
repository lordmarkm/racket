package com.racket.commons.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.baldy.commons.models.Sellable;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = "sellable")
public class RacketSellable implements Sellable {

    @Id @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
