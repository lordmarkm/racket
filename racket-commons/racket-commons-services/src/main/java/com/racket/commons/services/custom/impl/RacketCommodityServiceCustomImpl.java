package com.racket.commons.services.custom.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.services.RacketCommodityServiceCustom;
import com.racket.commons.services.RacketCommodityService;

import static com.racket.commons.models.support.TransactionDetailType.*;
import static com.racket.commons.services.utils.DateTimeUtil.*;

/**
 * @author Mark
 */
@Component
public class RacketCommodityServiceCustomImpl implements RacketCommodityServiceCustom {

    private static Logger log = LoggerFactory.getLogger(RacketCommodityServiceCustomImpl.class);

    @Resource
	private RacketCommodityService commodities;
	
	@Override
	public Transaction completeRentalTransaction(RacketCommodity commodity) {
		// TODO
		DateTime rentalStarted = commodity.getRentalDetails().getRentalStarted();
	    DateTime rentalEnded = commodity.getRentalDetails().getRentalEnd();

		Transaction transaction = new Transaction();
	    transaction.setDate(rentalEnded);
	    transaction.setMessage("Rental ended on " + rentalEnded);

	    //Compute Rental value
	    DateTime chargeableEndTime = roundUp(rentalEnded, commodity.getRentalDetails().getRoundUp());
	    log.debug("Rental started={}, ended={}", rentalStarted, rentalEnded);
	    int chargeableMinutes = Minutes.minutesBetween(rentalStarted, chargeableEndTime).getMinutes();
	    log.debug("Computed chargeable minutes = {}", chargeableMinutes);
	    BigDecimal value = commodity.getRentalDetails().getPricePerMinute().multiply(BigDecimal.valueOf(chargeableMinutes));
	    if (value.compareTo(commodity.getRentalDetails().getMinimumCharge()) < 0) {
	    	value = commodity.getRentalDetails().getMinimumCharge();
	    }
	    transaction.setValue(value);

	    //Add Rental transaction details
	    List<TransactionDetail> details = transaction.getDetails();

	    TransactionDetail commodityDetail = new TransactionDetail(COMMODITY_ID, commodity.getId(), commodity.getName(), null);
	    details.add(commodityDetail);

	    TransactionDetail rentalStartDetail = new TransactionDetail(RENTAL_START, 0, "Rental started", commodity.getRentalDetails().getRentalStarted().toString());
	    details.add(rentalStartDetail);

	    TransactionDetail rentalEndDetail = new TransactionDetail(RENTAL_END, 0, "Rental end", rentalEnded.toString());
	    details.add(rentalEndDetail);

	    commodity.getRentalDetails().setRentalStarted(null);
		commodity.getRentalDetails().setRentalEnd(null);
		commodities.save(commodity);

		return transaction;
	}

}
