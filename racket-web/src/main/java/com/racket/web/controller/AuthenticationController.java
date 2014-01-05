package com.racket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.racket.web.dto.AccountForm;

/**
 * @author mbmartinez
 */
@Controller
@RequestMapping("/auth")
public interface AuthenticationController {

    @RequestMapping("/login")
    public ModelAndView login(String message, String error);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register();

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(AccountForm form, BindingResult result);

    @InitBinder
	public void initBinder(WebDataBinder binder);

}
