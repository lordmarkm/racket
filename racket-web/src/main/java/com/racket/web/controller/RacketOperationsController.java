package com.racket.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for racket operations (rental start, purchase, etc etc)
 * @author Mark
 */
@Controller
@RequestMapping("/racketoperations")
public interface RacketOperationsController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView operationsTemplate(Principal principal);
	
}
