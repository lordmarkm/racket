package com.racket.commons.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.baldy.commons.models.Commodity;
import com.google.common.collect.Lists;
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

    @Embedded
    private RentalDetails rentalDetails = new RentalDetails();

    @Embedded
    private RetailDetails retailDetails = new RetailDetails();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommodityType type;

    @Column
    private BigDecimal price;

    @Column
    private String unit;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

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

    public RentalDetails getRentalDetails() {
        return rentalDetails != null ? rentalDetails : new RentalDetails();
    }

    public void setRentalDetails(RentalDetails rentalDetails) {
        this.rentalDetails = rentalDetails;
    }

    public RetailDetails getRetailDetails() {
        return retailDetails != null ? retailDetails : new RetailDetails();
    }

    public void setRetailDetails(RetailDetails retailDetails) {
        this.retailDetails = retailDetails;
    }

    public List<Image> getImages() {
        if (null == images) {
            images = Lists.newArrayList();
        }
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
