package com.racket.security.methodsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketService;

/**
 * Custom methods here
 * @author Mark
 */
public class RacketSecurityExpressionRootCustom extends RacketSecurityExpressionRoot {

	private Logger log = LoggerFactory.getLogger(RacketSecurityExpressionRoot.class);

	private RacketService rackets;
	private RacketCommodityService commodities;

	public RacketSecurityExpressionRootCustom(Authentication a) {
		super(a);
	}

    /**
     * For securing rackets
     * @param username - usually principal.name
     * @param racketId
     */
    public boolean canManage(String username, Long racketId) {
    	log.info("Checking manage permission. username={}, racketId={}", username, racketId);
    	Racket racket = rackets.findOne(racketId);
    	return rackets.canManage(racket, username);
    }

    public boolean canManageParent(String username, Long commodityId) {
    	log.info("Checking manage permission. username={}, commodityId={}", username, commodityId);
    	return true;
    }

    /**
     * For security commodities at Operate permission level
     */
    public boolean canOperateParent(String username, Long commodityId) {
    	RacketCommodity commodity = commodities.findOne(commodityId);
    	Racket parent = commodity.getRacket();
    	return rackets.canOperate(parent, username);
    }

    public boolean hasPermission() {
    	log.info("Lol, look at this faggot!");
    	return false;
    }

	public void setRackets(RacketService rackets) {
		this.rackets = rackets;
	}

	public void setCommodities(RacketCommodityService commodities) {
		this.commodities = commodities;
	}
}
