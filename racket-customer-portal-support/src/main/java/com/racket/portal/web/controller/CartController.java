package com.racket.portal.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.racket.portal.web.session.ShoppingCart;

/**
 * @author mbmartinez
 */
@Controller
public interface CartController {

    ResponseEntity<ShoppingCart> get(ShoppingCart cart);
    ResponseEntity<ShoppingCart> put(ShoppingCart cart, Long id);
    ResponseEntity<String> remove(ShoppingCart cart, Long id);

}
