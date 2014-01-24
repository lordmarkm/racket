package com.racket.notifications.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.racket.notifications.service.NotificationService;

@Configuration
@EnableJpaRepositories(basePackageClasses = NotificationService.class, repositoryImplementationPostfix = "CustomImpl")
public class NotificationsConfig {

}
