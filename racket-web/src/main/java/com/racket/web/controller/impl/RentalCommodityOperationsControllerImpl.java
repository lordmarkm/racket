package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.racket.notifications.model.Notification;
import com.racket.notifications.service.NotificationService;
import com.racket.web.controller.RentalCommodityOperationsController;

@Component
public class RentalCommodityOperationsControllerImpl extends GenericController implements RentalCommodityOperationsController {

    private static Logger log = LoggerFactory.getLogger(RentalCommodityOperationsControllerImpl.class);

    @Resource
	private RacketCommodityService commodities;

	@Resource
	private RacketeerService racketeers;

	@Resource
	private TransactionService transactions;

	@Resource
	private NotificationService notifs;

	@Override
	public ResponseEntity<String> startRental(Principal principal, Long id) {
	    
		RacketCommodity commodity = commodities.findOne(id);

		if (commodity.getRentalDetails().getRentalStarted() != null) {
			throw new IllegalArgumentException("It is in use!");
		}

		commodity.getRentalDetails().setRentalStarted(DateTime.now());
		commodities.save(commodity);

		log.debug("Rental started on commodity={}, id={}, rentalstart={}", commodity.getName(), commodity.getId(),
		        commodity.getRentalDetails().getRentalStarted());
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Notification> endRental(Principal principal, Long id) {

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

		Notification notif = notifs.compose(transaction);

		return new ResponseEntity<Notification>(notif, HttpStatus.OK);
	}

}
