package com.racket.security.methodsecurity;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


/**
 * Enables pre-post and stuff
 * @author mbmartinez
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//http://java.dzone.com/articles/writing-your-spring-security
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

	@Resource
	private RacketSecurityExpressionHandler expressionHandler;

	@Bean @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PermissionEvaluator permissionEvaluator() {
        return new RacketPermissionEvaluator();
    }

    @Override
    protected MethodSecurityExpressionHandler expressionHandler() {
    	return expressionHandler;
    }

}
