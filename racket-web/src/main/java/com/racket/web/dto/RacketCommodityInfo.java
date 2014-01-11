package com.racket.web.dto;

import java.math.BigDecimal;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.support.CommodityType;

/**
 * @author Mark
 */
public class RacketCommodityInfo {

	private RacketCommodity racketCommodity;
	
	public RacketCommodityInfo(RacketCommodity racketCommodity) {
		this.racketCommodity = racketCommodity;
	}
	
	public long getId() {
		return racketCommodity.getId();
	}

	public String getName() {
		return racketCommodity.getName();
	}

	public String getDescription() {
		return racketCommodity.getDescription();
	}

	public CommodityType getType() {
		return racketCommodity.getType();
	}

	public BigDecimal getPrice() {
		return racketCommodity.getPrice();
	}

	public String getUnit() {
		return racketCommodity.getUnit();
	}

}
