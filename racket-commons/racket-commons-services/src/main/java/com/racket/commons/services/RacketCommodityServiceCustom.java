package com.racket.commons.services;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Transaction;

/**
 * @author Mark
 */
public interface RacketCommodityServiceCustom {

    Transaction completeRentalTransaction(RacketCommodity commodity);

}
