package com.racket.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages="baldy.commons.security.services", repositoryImplementationPostfix="CustomImpl")
@EnableTransactionManagement
public class PersistenceConfig {
	
}
