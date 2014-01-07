package com.racket.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.racket.web.dto.RacketInfo;
import com.racket.web.dto.RacketeerRacketInfo;
import com.racket.web.forms.RacketForm;

/**
 * Rest controller for racket info
 * @author mbmartinez
 */
@Controller
@RequestMapping("/racket")
public interface RacketController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView racketTemplate();

    @ResponseBody
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView createRacketTemplate();

    @ResponseBody
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<RacketInfo> createRacket(Principal principal, RacketForm form);
    
    @ResponseBody
    @RequestMapping("/racketeerinfo")
    RacketeerRacketInfo getRacketeerRacketInfo(Principal principal);

}
