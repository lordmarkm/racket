package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Racketeer;
import com.racket.commons.services.RacketeerService;
import com.racket.web.controller.AccountController;

/**
 * @author Mark
 */
@Component
public class AccountControllerImpl extends GenericController implements AccountController {

	@Resource
	private RacketeerService racketeers;

	@Override
	public ModelAndView dashboard(Principal principal) {

		String username = principal.getName();
		
		Racketeer racketeer = racketeers.findByUsername(username);
		
		return mav("account/dashboard")
				.addObject("racketeer", racketeer);
	
	}

}
