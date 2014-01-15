package com.racket.web.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commodity")
public interface RetailCommodityOperationsController {

    @RequestMapping(value = "/restock/{id}/{amount}")
    public ResponseEntity<String> restock(Principal principal, @PathVariable("id") Long id,
            @PathVariable("amount") int amount);

    @RequestMapping(value = "/sold/{id}/{amount}")
    public ResponseEntity<String> sold(Principal principal, @PathVariable("id") Long id,
            @PathVariable("amount") int amount);

}
