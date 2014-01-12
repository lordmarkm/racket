package com.racket.web.controller.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.services.RacketCommodityService;
import com.racket.commons.services.RacketService;
import com.racket.web.controller.CommodityController;
import com.racket.web.dto.RacketCommodityInfo;
import com.racket.web.forms.CommodityForm;

/**
 * @author Mark
 */
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
	public ResponseEntity<RacketCommodityInfo> newCommodity(Principal principal, @RequestBody @Valid CommodityForm form) {

		log.info("Received new commodity request. form={}", form);
		
		Racket racket = rackets.findOne(form.getRacketId());
		RacketCommodity commodity = form.toCommodity();

		racket.getCommodities().add(commodity);
		commodity.setRacket(racket);

		rackets.save(racket);

		//Get the latest saved commodity from the racket. There has to be a better way to do this
		RacketCommodity saved = commodities.findByRacketId(racket.getId(), new PageRequest(0, 1, Direction.DESC, "id")).get(0);

		return new ResponseEntity<RacketCommodityInfo>(new RacketCommodityInfo(saved), HttpStatus.OK);
	}

	@Override
	public ModelAndView editCommodityTemplate(Principal principal) {
		return mav("commodity/edit");
	}

	@Override
	public ResponseEntity<RacketCommodityInfo> edit(Principal principal, @RequestBody CommodityForm form) {
		RacketCommodity commodity = form.toCommodity();
		Racket racket = rackets.findOne(form.getRacketId());
		commodity.setRacket(racket);
		commodity = commodities.save(commodity);
		return new ResponseEntity<RacketCommodityInfo>(new RacketCommodityInfo(commodity), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RacketCommodityInfo> commodityInfo(Principal principal, @PathVariable Long id) {
		RacketCommodity commodity = commodities.findOne(id);
		return new ResponseEntity<RacketCommodityInfo>(new RacketCommodityInfo(commodity), HttpStatus.OK);
	}

}
