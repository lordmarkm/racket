package com.racket.security.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.racket.security.methodsecurity.RacketSecurityExpressionHandler;


/**
 * Enables pre-post and stuff
 * @author mbmartinez
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//http://java.dzone.com/articles/writing-your-spring-security
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

	@Resource
	private RacketSecurityExpressionHandler eh;

	@Override
    protected MethodSecurityExpressionHandler expressionHandler() {
		return eh;
    }

}
