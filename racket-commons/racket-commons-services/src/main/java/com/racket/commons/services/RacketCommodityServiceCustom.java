package com.racket.commons.services;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.Transaction;

/**
 * @author Mark
 */
public interface RacketCommodityServiceCustom {

    /*
     * Retail ops
     */
    Transaction sold(RacketCommodity commodity, int amount);
    
    /*
     * Rental ops
     */
    Transaction completeRentalTransaction(RacketCommodity commodity);

}
