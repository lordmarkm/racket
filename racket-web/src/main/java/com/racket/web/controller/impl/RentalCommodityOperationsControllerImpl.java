package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Racketeer;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.models.support.TransactionDetailType;
import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketeerService;
import com.racket.commons.services.TransactionService;
import com.racket.web.controller.RentalCommodityOperationsController;

@Component
public class RentalCommodityOperationsControllerImpl extends GenericController implements RentalCommodityOperationsController {

	@Resource
	private RacketCommodityService commodities;

	@Resource
	private RacketeerService racketeers;

	@Resource
	private TransactionService transactions;

	@Override
	public ResponseEntity<String> startRental(Principal principal, Long id) {

		RacketCommodity commodity = commodities.findOne(id);

		if (commodity.getRentalDetails().getRentalStarted() != null) {
			throw new IllegalArgumentException("It is in use!");
		}

		commodity.getRentalDetails().setRentalStarted(new DateTime());
		commodities.save(commodity);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> endRental(Principal principal, Long id) {

		RacketCommodity commodity = commodities.findOne(id);
		if (commodity.getRentalDetails().getRentalStarted() == null) {
			throw new IllegalArgumentException("It's not in use!");
		}

		commodity.getRentalDetails().setRentalEnd(new DateTime());

		Transaction transaction = commodities.completeRentalTransaction(commodity);
		Racketeer operator = racketeers.findByUsername(principal.getName());
		
		TransactionDetail operatorDetail = new TransactionDetail(TransactionDetailType.OPERATOR_ID, operator.getId(), principal.getName(), "Operator");
		transaction.getDetails().add(operatorDetail);
		transactions.save(transaction);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
