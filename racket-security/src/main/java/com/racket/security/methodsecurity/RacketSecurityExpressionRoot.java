package com.racket.security.methodsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;

/**
 * Testing different EL security implems
 */
public class RacketSecurityExpressionRoot extends SecurityExpressionRoot {

    private Logger log = LoggerFactory.getLogger(RacketSecurityExpressionRoot.class);

    public RacketSecurityExpressionRoot(Authentication a) {
        super(a);
    }
    
    public boolean adminOnly() {
        log.debug("Admin only!");
        return false;
    }
    
}
