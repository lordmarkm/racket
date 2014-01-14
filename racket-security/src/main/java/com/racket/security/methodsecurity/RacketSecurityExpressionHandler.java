package com.racket.security.methodsecurity;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.racket.commons.services.RacketService;

/**
 * @author Mark
 */
@Component
public class RacketSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

	@Resource
	private RacketService racketService;

	@Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
    	RacketSecurityExpressionRootCustom root = new RacketSecurityExpressionRootCustom(authentication);
        root.setPermissionEvaluator(new RacketPermissionEvaluator());
        root.setRackets(racketService);
        return root;
    }

}
