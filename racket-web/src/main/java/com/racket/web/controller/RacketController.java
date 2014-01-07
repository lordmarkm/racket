package com.racket.web.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.racket.web.dto.RacketInfo;
import com.racket.web.dto.RacketeerInfo;
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
    ModelAndView racketTemplate();

    @ResponseBody
    @RequestMapping(value = "/racketinfo/{id}")
    ResponseEntity<RacketInfo> racketInfo(Principal principal, Long id);

    @ResponseBody
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    ModelAndView createRacketTemplate();

    @ResponseBody
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    ResponseEntity<RacketInfo> createRacket(Principal principal, RacketForm form);

    @ResponseBody
    @RequestMapping("/racketeerinfo")
    ResponseEntity<RacketeerInfo> getRacketeerInfoForSidebar(Principal principal);

}
