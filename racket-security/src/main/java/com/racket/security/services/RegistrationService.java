package com.racket.security.services;

import com.baldy.commons.security.models.Account;

/**
 * @author mbmartinez
 */
public interface RegistrationService {

    Account register(String username, String password);

}
