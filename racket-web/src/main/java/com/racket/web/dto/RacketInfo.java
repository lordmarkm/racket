package com.racket.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketCommodity;

/**
 * Dto for Racket, to be used for sidebar
 * @author mbmartinez
 */
public class RacketInfo {

    private Racket racket;
    private boolean canManage = false;
    private boolean canOperate = false;

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

    public List<RacketCommodityInfo> getCommodities() {
    	List<RacketCommodityInfo> commodityDtos = new ArrayList<RacketCommodityInfo>();
    	for (RacketCommodity commodity : racket.getCommodities()) {
    		commodityDtos.add(new RacketCommodityInfo(commodity));
    	}
    	return commodityDtos;
    }

    public boolean isCanManage() {
		return canManage;
	}

	public void setCanManage(boolean canManage) {
		this.canManage = canManage;
	}

	public boolean isCanOperate() {
		return canOperate;
	}

	public void setCanOperate(boolean canOperate) {
		this.canOperate = canOperate;
	}

}
