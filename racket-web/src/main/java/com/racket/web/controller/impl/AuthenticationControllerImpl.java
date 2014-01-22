package com.racket.web.controller.impl;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.jsoup.helper.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.security.models.Account;
import com.baldy.commons.security.services.AccountService;
import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.AccountInfo;
import com.racket.commons.models.Racketeer;
import com.racket.commons.services.RacketeerService;
import com.racket.security.services.RegistrationService;
import com.racket.web.controller.AuthenticationController;
import com.racket.web.forms.AccountForm;
import com.racket.web.validator.AccountFormValidator;


@Component
public class AuthenticationControllerImpl extends GenericController implements AuthenticationController {

    private static Logger log = LoggerFactory.getLogger(AuthenticationControllerImpl.class);

    @Resource
    private RegistrationService reg;

    @Resource
    private AccountService accounts;

    @Resource
    private RacketeerService racketeers;

    @Resource
    private AccountFormValidator validator;

    @Resource
    private MessageSource messages;
    
    @Override
    public ModelAndView login(@RequestParam(required = false, value = "message") String message, 
    		@RequestParam(required = false, value = "error") String error) {
        
    	ModelAndView mav = mav("authentication/login");

        if (null != message) {
        	mav.addObject("message", messages.getMessage(message, null, null));
        }

        if (null != error) {
        	mav.addObject("error", messages.getMessage(error, null, null));
        }

        return mav;
    }

    @Override
    public ModelAndView register() {
    	log.debug("Registration request received. Returning registration form.");
        return mav("authentication/register")
                .addObject("form", new AccountForm());
    }

    @Override
    public ModelAndView register(@Valid @ModelAttribute AccountForm form, BindingResult result) {

    	log.info("Registration request received. form={}", form);

    	log.info("Binding result={}", result);
    	
    	Validate.notNull(validator);
        if(result.hasErrors()) {
        	return mav("authentication/register")
        			.addObject("form", form)
        			.addObject("error", firstError(result));
        }

        String username = form.getUsername();
        String password = form.getPassword();
        Account account = reg.register(username, password);

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setJoined(new DateTime());

        Racketeer racketeer = new Racketeer();
        racketeer.setAccount(account);
        racketeer.setAccountInfo(accountInfo);
        racketeers.save(racketeer);

        return redirect("/auth/login?message=login.reg.success");
    }

    @InitBinder
	public void initBinder(WebDataBinder binder) {
    	binder.setValidator(validator);
    }

}
