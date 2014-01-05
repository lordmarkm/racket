package com.racket.commons.services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Mark
 */
@Configuration
@EnableJpaRepositories(basePackages="com.racket.commons.services", repositoryImplementationPostfix="CustomImpl")
public class RacketCommonsServicesConfig {

}
