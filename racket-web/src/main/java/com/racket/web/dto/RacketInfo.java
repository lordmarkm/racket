package com.racket.web.dto;

import com.racket.commons.models.Racket;

/**
 * Dto for Racket, to be used for sidebar
 * @author mbmartinez
 */
public class RacketInfo {

    private Racket racket;
    private boolean canManage = false;

    public RacketInfo(Racket racket) {
        this.racket = racket;
    }

    public long getId() {
        return racket.getId();
    }

    public String getName() {
        return racket.getName();
    }

    public String getDescription() {
        return racket.getDescription();
    }

	public boolean isCanManage() {
		return canManage;
	}

	public void setCanManage(boolean canManage) {
		this.canManage = canManage;
	}

}
