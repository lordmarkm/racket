package com.racket.commons.services.custom.impl;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.services.RacketCommodityServiceCustom;
import com.racket.commons.services.RacketCommodityService;

import static com.racket.commons.models.support.TransactionDetailType.*;

/**
 * @author Mark
 */
@Component
public class RacketCommodityServiceCustomImpl implements RacketCommodityServiceCustom {

	@Resource
	private RacketCommodityService commodities;
	
	@Override
	public Transaction completeRentalTransaction(RacketCommodity commodity) {
		// TODO
		DateTime rentalEndDate = commodity.getRentalDetails().getRentalEnd();
		
	    Transaction transaction = new Transaction();
	    transaction.setDate(rentalEndDate);
	    transaction.setMessage("Rental ended on " + rentalEndDate);
	    
	    //Compute Rental value
	    
	    
	    //Add Rental transaction details
	    List<TransactionDetail> details = transaction.getDetails();

	    TransactionDetail commodityDetail = new TransactionDetail(COMMODITY_ID, commodity.getId(), commodity.getName(), null);
	    details.add(commodityDetail);

	    TransactionDetail rentalStartDetail = new TransactionDetail(RENTAL_START, 0, "Rental started", commodity.getRentalDetails().getRentalStarted().toString());
	    details.add(rentalStartDetail);

	    TransactionDetail rentalEndDetail = new TransactionDetail(RENTAL_END, 0, "Rental end", rentalEndDate.toString());
	    details.add(rentalEndDetail);

	    commodity.getRentalDetails().setRentalStarted(null);
		commodity.getRentalDetails().setRentalEnd(null);
		commodities.save(commodity);

		return transaction;
	}

}
