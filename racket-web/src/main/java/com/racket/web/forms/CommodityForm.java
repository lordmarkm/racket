package com.racket.web.forms;

import java.math.BigDecimal;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.support.CommodityType;

/**
 * @author Mark
 */
public class CommodityForm {

	private Long racketId;
	private String name;
	private String description;
	private CommodityType type;
	private BigDecimal price;
	private String unit;
	
	public RacketCommodity toCommodity() {
		RacketCommodity commodity = new RacketCommodity();
		commodity.setDescription(description);
		commodity.setName(name);
		commodity.setPrice(price);
		commodity.setUnit(unit);
		return commodity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public Long getRacketId() {
		return racketId;
	}

	public void setRacketId(Long racketId) {
		this.racketId = racketId;
	}
	
}
