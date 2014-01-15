package com.racket.commons.models;

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
    private ChargingMethod chargingMethod;

    /**
     * Such as how internet cafes round to the nearest half hour
     */
    @Enumerated(EnumType.STRING)
    private RoundUp roundUp;

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
}
