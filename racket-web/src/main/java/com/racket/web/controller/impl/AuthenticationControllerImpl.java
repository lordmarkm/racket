package com.racket.web.controller.impl;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.security.services.AccountService;
import com.baldy.commons.web.controller.GenericController;
import com.baldy.commons.web.dto.JSON;
import com.racket.security.services.RegistrationService;
import com.racket.web.controller.AuthenticationController;
import com.racket.web.dto.AccountForm;


@Component
public class AuthenticationControllerImpl extends GenericController implements AuthenticationController {

    static Logger log = LoggerFactory.getLogger(AuthenticationControllerImpl.class);

    @Resource
    private RegistrationService reg;

    @Resource
    private AccountService accounts;

    @Override
    public ModelAndView login() {
    	return login(null);
    }

    @Override
    public ModelAndView login(@PathVariable String message) {
        return mav("login")
        		.addObject("message", message);
    }

    @Override
    public ModelAndView register() {
        
        log.debug("Registration request received. Returning registration form.");
        
        return mav("authentication/register")
                .addObject("form", new AccountForm());
    }

    //TODO put validation in a validator lol
    @Override
    public JSON register(@Valid AccountForm form, BindingResult result) {
        
        log.info("Registration request received. form={}", form);
        
        if(result.hasErrors()) {
            return JSON.error(result.getAllErrors().iterator().next().getDefaultMessage());
        }
        
        String username = form.getUsername();
        
        if(accounts.findByUsername(username) != null) {
            return JSON.error("Username " + username + " is already in use.");
        }
        
        String password = form.getPassword();
        String confirmPw = form.getConfirmpw();
        
        if(!password.equals(confirmPw)) {
            return JSON.error("Passwords must match.");
        }

        reg.register(username, password);

        return JSON.ok();
    }

}
