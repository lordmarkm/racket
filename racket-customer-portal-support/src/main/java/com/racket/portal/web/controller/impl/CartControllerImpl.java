package com.racket.portal.web.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.services.RacketCommodityService;
import com.racket.portal.web.controller.CartController;
import com.racket.portal.web.session.ShoppingCart;

/**
 * @author mbmartinez
 */
public class CartControllerImpl implements CartController {

    @Resource
    private RacketCommodityService commodityService;

    @Override
    public ResponseEntity<ShoppingCart> get(@ModelAttribute ShoppingCart cart) {
        return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ShoppingCart> put(@ModelAttribute ShoppingCart cart, @PathVariable Long id) {
        RacketCommodity commodity = commodityService.findOne(id);
        return new ResponseEntity<ShoppingCart>(cart.add(commodity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(@ModelAttribute ShoppingCart cart, Long id) {
        cart.remove(id);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}
