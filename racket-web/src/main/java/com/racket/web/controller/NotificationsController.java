package com.racket.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.racket.notifications.model.Notification;

/**
 * For notifs
 * @author mbmartinez
 */
@Controller
public interface NotificationsController {

    @ResponseBody
    @RequestMapping("/racket/latest/{id}/{start}/{end}")
    ResponseEntity<List<Notification>> getLatestForRacket(Principal principal, Long id, int start, int end);

}
