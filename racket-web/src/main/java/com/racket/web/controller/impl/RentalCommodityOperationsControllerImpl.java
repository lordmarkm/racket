package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.services.RacketCommodityService;
import com.racket.web.controller.RentalCommodityOperationsController;

@Component
public class RentalCommodityOperationsControllerImpl extends GenericController implements RentalCommodityOperationsController {

	@Resource
	private RacketCommodityService commodities;

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
		commodities.completeRentalTransaction(commodity);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
