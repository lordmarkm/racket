package com.racket.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.racket.commons.models.RacketCommodity;

/**
 * @author mbmartinez
 */
@Controller
public interface CartController {

    ResponseEntity<List<ShoppingCart>> get();
    ResponseEntity<ShoppingCart> put(ShoppingCart cart, Long id);
    ResponseEntity<String> delete(ShoppingCart cart, Long id);

}
