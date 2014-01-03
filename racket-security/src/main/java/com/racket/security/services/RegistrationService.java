package com.racket.security.services;

import baldy.commons.security.models.Account;

/**
 * @author mbmartinez
 */
public interface RegistrationService {

    Account register(String username, String password);

}
