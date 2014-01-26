package com.racket.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.racket.notifications.model.Notification;

/**
 * For notifs
 * @author mbmartinez
 */
@Controller
@RequestMapping("/racket")
public interface NotificationsController {

	@ResponseBody
	@RequestMapping("/notifs")
	ModelAndView notifsTemplate(Principal principal);
	
	@ResponseBody
	@RequestMapping("/notifs/{id}/{start}/{end}")
	ResponseEntity<List<NotificationInfo>> getLatestForRacket(Principal principal, Long id, int start, int end);

}
