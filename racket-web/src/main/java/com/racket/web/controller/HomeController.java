package com.racket.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Display default page
 * @author Mark
 */
@Controller
@RequestMapping("/index")
public interface HomeController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index(Principal principal);

}
