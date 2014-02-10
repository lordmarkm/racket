package com.racket.portal.web.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.racket.portal.web.controller.CartController;
import com.racket.portal.web.session.ShoppingCart;

public class CartControllerImpl implements CartController {

    @Override
    public ResponseEntity<List<ShoppingCart>> get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ShoppingCart> put(ShoppingCart cart, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<String> delete(ShoppingCart cart, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
