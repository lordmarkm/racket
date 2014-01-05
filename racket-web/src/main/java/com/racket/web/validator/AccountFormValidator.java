package com.racket.web.validator;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.baldy.commons.security.services.AccountService;
import com.racket.web.dto.AccountForm;

/**
 * @author Mark
 */
@Component
public class AccountFormValidator implements Validator {

	private static final Logger log = LoggerFactory.getLogger(AccountFormValidator.class);

	@Resource
    private AccountService accounts;

    @Resource
    private LocalValidatorFactoryBean defaultValidator;
    
    @Override
	public boolean supports(Class<?> clazz) {
    	log.debug("Checking if assignable. class={}, {}", clazz, clazz.isAssignableFrom(AccountForm.class));
		return clazz.isAssignableFrom(AccountForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//validate form annotations
		defaultValidator.validate(target, errors);

		AccountForm form = (AccountForm) target;
		log.debug("Validating. form={}", form);

		//validate username is not yet in use
        String username = form.getUsername();
        if(accounts.findByUsername(username) != null) {
            errors.rejectValue("username", null, "Username is already in use!");
        }

        //validate passwords match
        String password = form.getPassword();
        String confirmPw = form.getConfirmpw();
        if(!password.equals(confirmPw)) {
            errors.rejectValue("password", null, "Passwords must match!");
        }
	}

}
