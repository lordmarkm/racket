package com.racket.web.controller.impl;

import java.security.Principal;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.racket.commons.models.Image;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.services.RacketCommodityService;
import com.racket.web.controller.ImageController;
import com.racket.web.forms.ImageForm;

@Component
public class ImageControllerImpl implements ImageController {

    @Resource
    private RacketCommodityService commodities;

    @Override
    public ResponseEntity<Image> commodity(Principal principal, @PathVariable long id, @Valid @RequestBody ImageForm form) {

        RacketCommodity commodity = commodities.findOne(id);
        Image image = form.toImage();
        commodity.getImages().add(image);
        commodity = commodities.save(commodity);

        return new ResponseEntity<Image>(commodity.getImages().get(0), HttpStatus.OK);
    }

}
