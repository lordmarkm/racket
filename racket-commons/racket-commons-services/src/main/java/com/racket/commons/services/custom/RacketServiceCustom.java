package com.racket.commons.services.custom;

import com.racket.commons.models.Racket;

/**
 * @author mbmartinez
 */
public interface RacketServiceCustom {

    boolean canManage(Racket racket, String username);
    boolean hasManageAssociation(Racket racket, String username);

}
