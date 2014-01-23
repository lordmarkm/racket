package com.racket.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * For notifs
 * @author mbmartinez
 */
@Controller
public interface NotificationsController {

    @RequestMapping("/racket/latest/{id}")
    Notification getLatestForRacket(Principal principal, Long id);

}
