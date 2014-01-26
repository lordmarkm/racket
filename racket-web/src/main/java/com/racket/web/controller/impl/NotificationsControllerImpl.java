package com.racket.web.controller.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Racket;
import com.racket.commons.services.RacketService;
import com.racket.notifications.model.Notification;
import com.racket.notifications.service.NotificationService;
import com.racket.web.controller.NotificationsController;

/**
 * @author mbmartinez
 */
@Component
public class NotificationsControllerImpl extends GenericController implements NotificationsController {

    @Resource
    private NotificationService notifs;

    @Resource
    private RacketService rackets;

    @Override
	public ModelAndView notifsTemplate(Principal principal) {
		return mav("racket/notifs");
	}
    
    @Override
    public ResponseEntity<List<NotificationInfo>> getLatestForRacket(Principal principal, @PathVariable Long id,
            @PathVariable int start, @PathVariable int end) {

    	Racket racket = rackets.findOne(id);
        Pageable pageRequest = new PageRequest(start, end);
        return new ResponseEntity<List<NotificationInfo>>(notifs.findByRacket(racket, pageRequest), HttpStatus.OK);

    }

}
