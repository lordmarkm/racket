package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;

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
import com.racket.web.controller.RetailCommodityOperationsController;

/**
 * @author Mark
 */
@Component
public class RetailCommodityOperationsControllerImpl extends GenericController implements RetailCommodityOperationsController {

	private static final Logger log = LoggerFactory.getLogger(RetailCommodityOperationsControllerImpl.class);
	
	@Resource
	private RacketeerService racketeers;
	
	@Resource
	private TransactionService transactions;
	
	@Resource
	private RacketCommodityService commodities;

	@Resource
	private NotificationService notifs;

	@Override
	public ResponseEntity<String> restock(Principal principal, Long id, int amount) {
		log.debug("Sell operation. user={}, commodity={}, amount={}", name(principal), id, amount);
		RacketCommodity commodity = commodities.findOne(id);
		int currentAmount = commodity.getRetailDetails().getAmount();
		commodity.getRetailDetails().setAmount(currentAmount + amount);
		commodities.save(commodity);
		return new ResponseEntity<String>(HttpStatus.OK);	
	}

	@Override
	public ResponseEntity<Notification> sold(Principal principal, Long id, int amount) {
		log.debug("Sell operation. user={}, commodity={}, amount={}", name(principal), id, amount);
		RacketCommodity commodity = commodities.findOne(id);
		
		Transaction transaction = commodities.sold(commodity, amount);
        Racketeer operator = racketeers.findByUsername(principal.getName());
        
        TransactionDetail operatorDetail = new TransactionDetail(TransactionDetailType.OPERATOR_ID, operator.getId(), principal.getName(), "Operator");
        transaction.getDetails().add(operatorDetail);
        transactions.save(transaction);
		
		Notification notif = notifs.compose(transaction);
		
		return new ResponseEntity<Notification>(notif, HttpStatus.OK);
	}

}
