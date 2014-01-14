package com.racket.commons.services;

import com.racket.commons.models.Racket;

/**
 * @author mbmartinez
 */
public interface RacketServiceCustom {

	boolean canOperate(Racket racket, String name);
	boolean hasOperateAssociation(Racket racket, String username);
    boolean canManage(Racket racket, String username);
    boolean canManage(Long racketId, String username);
    boolean hasManageAssociation(Racket racket, String username);

}
