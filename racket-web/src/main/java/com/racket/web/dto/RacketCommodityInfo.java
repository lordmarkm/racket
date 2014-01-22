package com.racket.web.dto;

import java.math.BigDecimal;

import org.apache.commons.lang.Validate;
import org.joda.time.DateTime;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.support.ChargingMethod;
import com.racket.commons.models.support.CommodityType;
import com.racket.commons.models.support.RoundUp;

/**
 * @author Mark
 */
public class RacketCommodityInfo {

	private RacketCommodity racketCommodity;

	public RacketCommodityInfo(RacketCommodity racketCommodity) {
	    Validate.notNull(racketCommodity.getRentalDetails());
	    Validate.notNull(racketCommodity.getRetailDetails());
		this.racketCommodity = racketCommodity;
	}

	//Delegate methods to retail/rental detail!
    public int getStock() {
        return racketCommodity.getRetailDetails().getAmount();
    }

    public long getRentalStart() {
        DateTime rentalStarted = racketCommodity.getRentalDetails().getRentalStarted();
        if (null == rentalStarted) {
            return 0;
        } else {
            return rentalStarted.getMillis();
        }
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

	//rental details
	public ChargingMethod getChargingMethod() {
	    return racketCommodity.getRentalDetails().getChargingMethod();
	}
	public BigDecimal getPricePerMinute() {
	    return racketCommodity.getRentalDetails().getPricePerMinute();
	}
	public RoundUp getRoundUp() {
	    return racketCommodity.getRentalDetails().getRoundUp();
	}
}
