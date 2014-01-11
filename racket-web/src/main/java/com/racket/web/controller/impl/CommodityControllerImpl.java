package com.racket.web.controller.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketService;
import com.racket.web.controller.CommodityController;
import com.racket.web.dto.RacketCommodityInfo;
import com.racket.web.forms.CommodityForm;

@Component
public class CommodityControllerImpl extends GenericController implements CommodityController {

	private static final Logger log = LoggerFactory.getLogger(CommodityControllerImpl.class);

	@Resource
	private RacketService rackets;

	@Resource
	private RacketCommodityService commodities;

	@Override
	public ResponseEntity<List<RacketCommodityInfo>> findByRacket(Principal principal, @PathVariable Long racketId) {

		log.debug("Racket list requested. user={}, racketId={}", name(principal), racketId);
		
		List<RacketCommodity> racketCommodities = commodities.findByRacketId(racketId);
		
		return new ResponseEntity<List<RacketCommodityInfo>>(toRacketCommodityInfo(racketCommodities), HttpStatus.OK);
	}

	private List<RacketCommodityInfo> toRacketCommodityInfo(List<RacketCommodity> commodities) {
		List<RacketCommodityInfo> infos = new ArrayList<RacketCommodityInfo>();
		
		for (RacketCommodity commodity : commodities) {
			infos.add(new RacketCommodityInfo(commodity));
		}
		
		return infos;
	}

	@Override
	public ResponseEntity<RacketCommodityInfo> newCommodity(Principal principal, @Valid CommodityForm form) {

		Racket racket = rackets.findOne(form.getRacketId());
		RacketCommodity commodity = form.toCommodity();

		RacketCommodity saved = commodities.save(commodity);
		
		racket.getCommodities().add(commodity);
		commodity.setRacket(racket);
		
		rackets.save(racket);
		
		return null;
	}

}
