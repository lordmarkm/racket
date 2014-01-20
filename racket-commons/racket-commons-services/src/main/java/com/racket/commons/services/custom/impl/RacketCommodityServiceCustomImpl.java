package com.racket.commons.services.custom.impl;

import java.util.List;

import javax.annotation.Resource;

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
	    Transaction transaction = new Transaction();
	    List<TransactionDetail> details = transaction.getDetails();

	    TransactionDetail commodityDetail = new TransactionDetail(COMMODITY_ID, commodity.getId(), commodity.getName(), null);
	    details.add(commodityDetail);

	    TransactionDetail rentalStart = new TransactionDetail(RENTAL_START, commodity.getRentalDetails().getRentalStarted())

	    commodity.getRentalDetails().setRentalStarted(null);
		commodity.getRentalDetails().setRentalEnd(null);
		commodities.save(commodity);

		return transaction;
	}

}
