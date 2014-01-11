package com.racket.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.racket.web.dto.RacketCommodityInfo;
import com.racket.web.forms.CommodityForm;

@Controller
@RequestMapping("/commodity")
public interface CommodityController {

	@ResponseBody
	@RequestMapping("/byracket/{racketId}")
	ResponseEntity<List<RacketCommodityInfo>> findByRacket(Principal principal, Long racketId);

	@ResponseBody
	@RequestMapping("/new")
	ResponseEntity<RacketCommodityInfo> newCommodity(Principal principal, CommodityForm form);

}
