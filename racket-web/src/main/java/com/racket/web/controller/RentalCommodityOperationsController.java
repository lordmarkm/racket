package com.racket.web.controller;

import java.security.Principal;

import javax.management.Notification;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Mark
 *
 */
@Controller
@RequestMapping("/commodity")
public interface RentalCommodityOperationsController {

	@PreAuthorize("canOperateParent(#principal.name, #id)")
	@RequestMapping("/rentalstart/{id}")
	@ResponseBody
	ResponseEntity<String> startRental(Principal principal, @PathVariable("id") Long id);

	@PreAuthorize("canOperateParent(#principal.name, #id)")
	@RequestMapping("/rentalend/{id}")
	@ResponseBody
	ResponseEntity<Notification> endRental(Principal principal, @PathVariable("id") Long id);

}
