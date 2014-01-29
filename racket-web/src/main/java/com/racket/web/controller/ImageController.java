package com.racket.web.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.racket.commons.models.Image;
import com.racket.web.forms.ImageForm;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/image")
public interface ImageController {

    @RequestMapping(value = "/commodity/{id}", method = POST)
    ResponseEntity<Image> commodity(Principal principal, long id, ImageForm image);

}
