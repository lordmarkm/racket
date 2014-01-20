package com.racket.commons.services;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.RacketTransaction;

/**
 * @author Mark
 */
public interface RacketCommodityServiceCustom {

	RacketTransaction completeRentalTransaction(RacketCommodity commodity);

}
