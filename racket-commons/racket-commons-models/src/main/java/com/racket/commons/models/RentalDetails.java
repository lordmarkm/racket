package com.racket.commons.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

import com.racket.commons.models.support.ChargingMethod;
import com.racket.commons.models.support.RoundUp;

/**
 * @author mbmartinez
 */
@Embeddable
public class RentalDetails {

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")    
    private DateTime rentalStarted;

    /**
     * Suppose this could be scheduled rental end, since storing last rental end doesn't make much sense
     */
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")    
    private DateTime rentalEnd;

    @Enumerated(EnumType.STRING)
    private ChargingMethod chargingMethod = ChargingMethod.PER_MINUTE;

    /**
     * Price is computed from here
     */
    @Column
    private BigDecimal pricePerMinute = BigDecimal.valueOf(0);

    /**
     * Minimum charge
     */
    @Column
    private BigDecimal minimumCharge = BigDecimal.valueOf(0.0);

    /**
     * Such as how internet cafes round to the nearest half hour
     */
    @Enumerated(EnumType.STRING)
    private RoundUp roundUp = RoundUp.NEXT_HALF_HOUR;

    public String toString() {
        return new ToStringCreator(this)
            .append("started", rentalStarted)
            .append("end", rentalEnd)
            .append("charging", chargingMethod)
            .append("roundup", roundUp)
            .toString();
    }
    
    public DateTime getRentalStarted() {
        return rentalStarted;
    }

    public void setRentalStarted(DateTime rentalStarted) {
        this.rentalStarted = rentalStarted;
    }

    public DateTime getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(DateTime rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public ChargingMethod getChargingMethod() {
        return chargingMethod;
    }

    public void setChargingMethod(ChargingMethod chargingMethod) {
        this.chargingMethod = chargingMethod;
    }

    public RoundUp getRoundUp() {
        return roundUp;
    }

    public void setRoundUp(RoundUp roundUp) {
        this.roundUp = roundUp;
    }

    public BigDecimal getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(BigDecimal pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
    
	public BigDecimal getMinimumCharge() {
		return minimumCharge;
	}

	public void setMinimumCharge(BigDecimal minimumCharge) {
		this.minimumCharge = minimumCharge;
	}

}
