package com.racket.commons.services.custom.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.RacketTransaction;
import com.racket.commons.services.RacketCommodityServiceCustom;
import com.racket.commons.services.RacketCommodityService;

/**
 * @author Mark
 */
@Component
public class RacketCommodityServiceCustomImpl implements RacketCommodityServiceCustom {

	@Resource
	private RacketCommodityService commodities;
	
	@Override
	public RacketTransaction completeRentalTransaction(RacketCommodity commodity) {
		// TODO
		commodity.getRentalDetails().setRentalStarted(null);
		commodity.getRentalDetails().setRentalEnd(null);
		commodities.save(commodity);
		return null;
	}

}
