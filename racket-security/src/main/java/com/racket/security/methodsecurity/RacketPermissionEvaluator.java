package com.racket.security.methodsecurity;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author mbmartinez
 */
public class RacketPermissionEvaluator implements PermissionEvaluator {

    private static Logger log = LoggerFactory.getLogger(RacketPermissionEvaluator.class);

    @Override
    public boolean hasPermission(Authentication authentication,
            Object targetDomainObject, Object permission) {

        log.debug("Permission check! auth={}, obj={}, perm={}", authentication, targetDomainObject, permission);

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication,
            Serializable targetId, String targetType, Object permission) {

        log.debug("Permission check! auth={}, id={}, type={}, perm={}", authentication, targetId, targetType, permission);

        return false;
    }

}
