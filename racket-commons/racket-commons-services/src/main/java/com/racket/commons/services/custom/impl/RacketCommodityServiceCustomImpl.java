package com.racket.commons.services.custom.impl;

import static com.racket.commons.models.support.TransactionDetailType.COMMODITY_ID;
import static com.racket.commons.models.support.TransactionDetailType.RENTAL_END;
import static com.racket.commons.models.support.TransactionDetailType.RENTAL_START;
import static com.racket.commons.services.utils.DateTimeUtil.getRoundedChargeableMinutes;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketCommodityServiceCustom;

/**
 * @author Mark
 */
@Component
public class RacketCommodityServiceCustomImpl implements RacketCommodityServiceCustom {

    private static Logger log = LoggerFactory.getLogger(RacketCommodityServiceCustomImpl.class);

    @Resource
	private RacketCommodityService commodities;
    
    @Override
    public Transaction sold(RacketCommodity commodity, int amount) {
        int currentAmount = commodity.getRetailDetails().getAmount();
        commodity.getRetailDetails().setAmount(currentAmount - amount);
        commodities.save(commodity);
        
        Transaction transaction = new Transaction();
        transaction.setDate(DateTime.now());
        transaction.setMessage(amount + " of " + commodity.getName() + " sold on " + transaction.getDate().toString());
        transaction.setValue(commodity.getPrice().multiply(BigDecimal.valueOf(amount)));
        
        //Add retail transaction details
        List<TransactionDetail> details = transaction.getDetails();

        TransactionDetail commodityDetail = new TransactionDetail(COMMODITY_ID, commodity.getId(), "Commodity", commodity.getName());
        details.add(commodityDetail);
        
        return transaction;
    }
    
    /**
     * Rental op
     */
	@Override
	public Transaction completeRentalTransaction(RacketCommodity commodity) {
		// TODO
		DateTime rentalStarted = commodity.getRentalDetails().getRentalStarted();
	    DateTime rentalEnded = commodity.getRentalDetails().getRentalEnd();
	    BigDecimal minimumCharge = commodity.getRentalDetails().getMinimumCharge();

	    Transaction transaction = new Transaction();
	    transaction.setDate(rentalEnded);
	    transaction.setMessage("Rental ended on " + rentalEnded);

	    //Compute Rental value
	    log.debug("Rental started={}, ended={}", rentalStarted, rentalEnded);
	    int chargeableMinutes = getRoundedChargeableMinutes(rentalStarted, rentalEnded, commodity.getRentalDetails().getRoundUp()); 
	    log.debug("Computed chargeable minutes = {}", chargeableMinutes);
	    BigDecimal value = commodity.getRentalDetails().getPricePerMinute().multiply(BigDecimal.valueOf(chargeableMinutes));
	    if (value.compareTo(minimumCharge) < 0) {
	        log.debug("Computed charge is less than minimum charge. Setting to minimum. computed={}, min={}", value, minimumCharge);
	        value = minimumCharge;
	    }
	    transaction.setValue(value);

	    //Add Rental transaction details
	    List<TransactionDetail> details = transaction.getDetails();

	    TransactionDetail commodityDetail = new TransactionDetail(COMMODITY_ID, commodity.getId(), "Commodity", commodity.getName());
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
