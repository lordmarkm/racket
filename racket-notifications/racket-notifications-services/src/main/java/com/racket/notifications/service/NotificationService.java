package com.racket.notifications.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.notifications.model.Notification;
import com.racket.notifications.service.custom.NotificationServiceCustom;

public interface NotificationService extends JpaRepository<Notification, Long>, NotificationServiceCustom {

    List<Notification> findByRacket(Long id, Pageable pageRequest);

}
