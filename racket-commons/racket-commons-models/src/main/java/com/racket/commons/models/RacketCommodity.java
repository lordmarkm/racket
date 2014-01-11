package com.racket.commons.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baldy.commons.models.Commodity;
import com.racket.commons.models.support.CommodityType;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = RacketCommodity.table)
public class RacketCommodity extends AbstractEntity implements Commodity {

    public static final String table = "commodities";

    @ManyToOne(optional = false)
    private Racket racket;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommodityType type;

    @Column
    private BigDecimal price;

    @Column
    private String unit;

    public CommodityType getType() {
        return type;
    }

    public void setType(CommodityType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

	public Racket getRacket() {
		return racket;
	}

	public void setRacket(Racket racket) {
		this.racket = racket;
	}

}
