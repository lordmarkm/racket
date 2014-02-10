package com.racket.portal.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.racket.portal.web.session.ShoppingCart;

/**
 * @author mbmartinez
 */
@Controller
public interface CartController {

    ResponseEntity<List<ShoppingCart>> get();
    ResponseEntity<ShoppingCart> put(ShoppingCart cart, Long id);
    ResponseEntity<String> delete(ShoppingCart cart, Long id);

}
