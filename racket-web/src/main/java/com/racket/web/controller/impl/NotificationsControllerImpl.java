package com.racket.web.controller.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.racket.notifications.model.Notification;
import com.racket.notifications.service.NotificationService;
import com.racket.web.controller.NotificationsController;

/**
 * @author mbmartinez
 */
public class NotificationsControllerImpl implements NotificationsController {

    @Resource
    private NotificationService notifs;

    @Override
    public ResponseEntity<List<Notification>> getLatestForRacket(Principal principal, @PathVariable Long id,
            @PathVariable int start, @PathVariable int end) {

        Pageable pageRequest = new PageRequest(start, end);
        return new ResponseEntity<List<Notification>>(notifs.findByRacket(id, pageRequest), HttpStatus.OK);

    }

}
