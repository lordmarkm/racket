package com.racket.commons.services.custom.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketAssociation;
import com.racket.commons.models.support.RacketAuthority;
import com.racket.commons.services.RacketService;
import com.racket.commons.services.RacketServiceCustom;

/**
 * @author mbmartinez
 */
public class RacketServiceCustomImpl implements RacketServiceCustom {

//	@Resource
//	private RacketService rackets;

	@Override
	public boolean canOperate(Racket racket, String username) {
        return racket.getRacketeer().getAccount().getUsername().equals(username)
                || hasManageAssociation(racket, username);
	}

	@Override
	public boolean hasOperateAssociation(Racket racket, String username) {
        Set<RacketAssociation> associations = racket.getAssociations();

        for (RacketAssociation association : associations) {
            if ((association.getAuthority() == RacketAuthority.ADMIN 
                    || association.getAuthority() == RacketAuthority.CAN_OPERATE)
                    && association.getRacketeer().getAccount().getUsername().equals(username))
                return true;
        }

        return false;
	}

	@Override
	public boolean canManage(Long racketId, String username) {
//		Racket racket = rackets.findOne(racketId);
//		return canManage(racket, username);
		return false;
	}

	@Override
    public boolean canManage(Racket racket, String username) {
        return racket.getRacketeer().getAccount().getUsername().equals(username)
                || hasManageAssociation(racket, username);
    }

    @Override
    public boolean hasManageAssociation(Racket racket, String username) {
        Set<RacketAssociation> associations = racket.getAssociations();

        for (RacketAssociation association : associations) {
            if ((association.getAuthority() == RacketAuthority.ADMIN 
                    || association.getAuthority() == RacketAuthority.CAN_MANAGE)
                    && association.getRacketeer().getAccount().getUsername().equals(username))
                return true;
        }

        return false;
    }

}
