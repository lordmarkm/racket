package com.racket.security.methodsecurity;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;


/**
 * Enables pre-post and stuff
 * @author mbmartinez
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//http://www.borislam.com/2012/08/writing-your-spring-security-expression_9.html
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Bean @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PermissionEvaluator permissionEvaluator() {
        return new RacketPermissionEvaluator();
    }
    
    @Override
    protected SecurityExpressionRoot createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        RacketSecurityExpressionRoot root = new RacketSecurityExpressionRoot(authentication);
        root.setPermissionEvaluator(permissionEvaluator());
        return root;
    }


    @Override
    protected MethodSecurityExpressionHandler expressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator());
        return expressionHandler;
    }

}
