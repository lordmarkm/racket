package com.racket.security.methodsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import com.racket.commons.models.Racket;
import com.racket.commons.services.RacketService;

/**
 * Custom methods here
 * @author Mark
 */
public class RacketSecurityExpressionRootCustom extends RacketSecurityExpressionRoot {

	private Logger log = LoggerFactory.getLogger(RacketSecurityExpressionRoot.class);

	private RacketService rackets;
	
    public RacketSecurityExpressionRootCustom(Authentication a) {
		super(a);
	}

    public boolean canManage(String username, Long racketId) {
    	log.info("Checking manage permission. username={}, racketId={}", username, racketId);
    	Racket racket = rackets.findOne(racketId);
    	return rackets.canManage(racket, username);
    }

    public boolean hasPermission() {
    	log.info("Lol, look at this faggot!");
    	return false;
    }

	public void setRackets(RacketService rackets) {
		this.rackets = rackets;
	}
}
