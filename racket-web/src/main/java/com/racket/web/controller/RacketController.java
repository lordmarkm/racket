package com.racket.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.racket.web.dto.RacketeerRacketInfo;

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
    @RequestMapping("/new")
    public ModelAndView createRacketTemplate();

    @ResponseBody
    @RequestMapping("/racketeerinfo")
    RacketeerRacketInfo getRacketeerRacketInfo(Principal principal);

}
