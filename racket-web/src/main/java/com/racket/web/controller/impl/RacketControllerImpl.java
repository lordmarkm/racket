package com.racket.web.controller.impl;

import java.security.Principal;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.web.controller.RacketController;
import com.racket.web.dto.RacketeerRacketInfo;

@Component
public class RacketControllerImpl extends GenericController implements RacketController {

    @Override
    public ModelAndView racketTemplate() {
        return mav("racket/racket");
    }

    @Override
    public ModelAndView createRacketTemplate() {
        return mav("racket/createracket");
    }
    
    @Override
    public RacketeerRacketInfo getRacketeerRacketInfo(Principal principal) {
        // TODO Auto-generated method stub
        return null;
    }

}
