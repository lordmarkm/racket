package com.racket.web.controller.impl;

import java.security.Principal;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.web.controller.RacketOperationsController;

/**
 * @author Mark
 */
@Component
public class RacketOperationsControllerImpl extends GenericController implements RacketOperationsController {

	@Override
	public ModelAndView operationsTemplate(Principal principal) {
		return mav("racket/operations");
	}

}
