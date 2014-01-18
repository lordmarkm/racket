package com.racket.security.methodsecurity;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketService;

/**
 * @author Mark
 */
@Component
public class RacketSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

	private RacketService rackets;
	private RacketCommodityService comms;

//	@Resource
//	private RacketPermissionEvaluator permissionEvaluator;
	
	@Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
    	RacketSecurityExpressionRootCustom root = new RacketSecurityExpressionRootCustom(authentication);
        root.setPermissionEvaluator(new RacketPermissionEvaluator());
        root.setRackets(rackets);
        root.setCommodities(comms);
        return root;
    }

	public void setRackets(RacketService rackets) {
		this.rackets = rackets;
	}

	public void setComms(RacketCommodityService comms) {
		this.comms = comms;
	}

}
