package com.racket.security.config;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.Validate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketService;
import com.racket.security.methodsecurity.RacketSecurityExpressionHandler;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages={"com.baldy.commons.security.services"},
repositoryImplementationPostfix="CustomImpl")
@EnableTransactionManagement
public class RacketSecurityPersistenceConfig {

    /*
     * The beans below should be in MethodSecurityConfig. I still don't understand why
     * neither Service can be autowired into that config context. WTF.
     */

    @Resource
    private RacketService rackets;

    @Resource
    private RacketCommodityService comms;

    @Resource
    private RacketSecurityExpressionHandler eh;

    @PostConstruct
    public void setServices() {
        Validate.notNull(comms);
        Validate.notNull(rackets);
        eh.setComms(comms);
        eh.setRackets(rackets);
    }
}
