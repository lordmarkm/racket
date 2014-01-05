package com.racket.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Mark
 */
@Controller
@RequestMapping("/account")
public interface AccountController {

	@RequestMapping("/dashboard")
	ModelAndView dashboard(Principal principal);

}
