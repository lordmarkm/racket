package com.racket.web.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.racket.notifications.model.Notification;

@Controller
@RequestMapping("/commodity")
public interface RetailCommodityOperationsController {

    @PreAuthorize("canOperateParent(#principal.name, #id)")
    @RequestMapping(value = "/restock/{id}/{amount}")
    public ResponseEntity<String> restock(Principal principal, @PathVariable("id") Long id,
            @PathVariable("amount") int amount);

	@PreAuthorize("canOperateParent(#principal.name, #id)")
    @RequestMapping(value = "/sold/{id}/{amount}")
    public ResponseEntity<Notification> sold(Principal principal, @PathVariable("id") Long id,
            @PathVariable("amount") int amount);

}
