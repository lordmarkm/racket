package com.racket.web.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    ResponseEntity<RacketInfo> racketInfo(Principal principal, @PathVariable("id") Long id);

    @ResponseBody
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    ModelAndView createRacketTemplate();

    @ResponseBody
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    ResponseEntity<RacketInfo> createRacket(Principal principal, @RequestBody RacketForm form);

    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    ModelAndView manageRacketTemplate();

    @ResponseBody
    @RequestMapping("/racketeerinfo")
    ResponseEntity<RacketeerInfo> getRacketeerInfoForSidebar(Principal principal);

    @PreAuthorize("canManage(#principal.name, #id)")
    @ResponseBody
    @RequestMapping("/delete/{id}")
    ResponseEntity<String> delete(Principal principal, @PathVariable("id") Long id);

}
