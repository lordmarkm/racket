package com.racket.commons.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Mark
 */
@Configuration
@EnableJpaRepositories(basePackages="com.baldy.commons.security.services", repositoryImplementationPostfix="CustomImpl")
public class TestConfig {

}
