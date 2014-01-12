package com.racket.web.controller.impl;

import java.security.Principal;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.web.controller.HomeController;

/**
 * User home page (dashboard)
 * @author Mark
 */
@Component
public class HomeControllerImpl extends GenericController implements HomeController {

	@Override
	public ModelAndView index(Principal principal) {
		return mav("home/index");
	}

}
