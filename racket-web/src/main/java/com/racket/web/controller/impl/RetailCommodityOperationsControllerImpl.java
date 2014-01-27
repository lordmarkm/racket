package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Racketeer;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.models.support.TransactionDetailType;
import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketService;
import com.racket.commons.services.RacketeerService;
import com.racket.commons.services.TransactionService;
import com.racket.notifications.model.Notification;
import com.racket.notifications.service.NotificationService;
import com.racket.web.controller.RetailCommodityOperationsController;
import com.racket.web.dto.NotificationInfo;

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

	@Resource
	private RacketService rackets;
	
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
	public ResponseEntity<NotificationInfo> sold(Principal principal, Long id, int amount) {
		log.debug("Sell operation. user={}, commodity={}, amount={}", name(principal), id, amount);
		RacketCommodity commodity = commodities.findOne(id);
		
		Transaction transaction = commodities.sold(commodity, amount);
        Racketeer operator = racketeers.findByUsername(principal.getName());
        
        TransactionDetail operatorDetail = new TransactionDetail(TransactionDetailType.OPERATOR_ID, operator.getId(), "Operator", principal.getName());
        transaction.getDetails().add(operatorDetail);

        Racket racket = commodity.getRacket();
        transaction.setRacket(racket);
        racket.getTransactions().add(transaction);
        rackets.save(racket);

        Notification notif = notifs.compose(commodity.getRacket(), transaction);
		NotificationInfo dto = new NotificationInfo(notif);
		
		return new ResponseEntity<NotificationInfo>(dto, HttpStatus.OK);
	}

}
