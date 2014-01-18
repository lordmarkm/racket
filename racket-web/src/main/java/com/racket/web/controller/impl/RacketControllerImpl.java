package com.racket.web.controller.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Racket;
import com.racket.commons.models.Racketeer;
import com.racket.commons.services.RacketService;
import com.racket.commons.services.RacketeerService;
import com.racket.web.controller.RacketController;
import com.racket.web.dto.RacketInfo;
import com.racket.web.dto.RacketeerInfo;
import com.racket.web.forms.RacketForm;

/**
 * @author mbmartinez
 */
@Component
public class RacketControllerImpl extends GenericController implements RacketController {

    private static Logger log = LoggerFactory.getLogger(RacketControllerImpl.class);

    @Resource
    private RacketeerService racketeers;

    @Resource
    private RacketService rackets;

    @Override
    public ModelAndView racketTemplate() {
        return mav("racket/racket");
    }

	@Override
	public ResponseEntity<RacketInfo> racketInfo(Principal principal, Long id) {
		log.debug("Racket info requested. user={}, id={}", name(principal), id);

		Racket racket = rackets.findOne(id);
		RacketInfo racketInfo = new RacketInfo(racket);
		racketInfo.setCanOperate(rackets.canOperate(racket, name(principal)));
		racketInfo.setCanManage(rackets.canManage(racket, name(principal)));

		return new ResponseEntity<RacketInfo>(racketInfo, HttpStatus.OK);
	}
    
    @Override
    public ModelAndView createRacketTemplate() {
        return mav("racket/createracket");
    }

    @Override
    public ResponseEntity<RacketInfo> createRacket(Principal principal, @RequestBody @Valid RacketForm form) {

        Racketeer racketeer = racketeers.findByUsername(principal.getName());
        Racket racket = form.toRacket();
        racket.setRacketeer(racketeer);

        log.debug("Create racket request received. form={}", form);

        Racket saved = rackets.save(racket);

        return new ResponseEntity<RacketInfo>(new RacketInfo(saved), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RacketeerInfo>  getRacketeerInfoForSidebar(Principal principal) {

    	log.debug("Racketeer info requested. user={}", name(principal));

    	Racketeer racketeer = racketeers.findByUsername(principal.getName());

    	//PageRequest pageRequest = new PageRequest(0, 10);
    	//List<Racket> userRackets = rackets.findByRacketeer(racketeer, pageRequest).getContent();
    	List<Racket> userRackets = rackets.findByRacketeer(racketeer);

    	RacketeerInfo sidebarInfo = new RacketeerInfo();
    	sidebarInfo.convertAndSetRackets(userRackets);

    	return new ResponseEntity<RacketeerInfo>(sidebarInfo, HttpStatus.OK);
    }

    @Override
    public ModelAndView manageRacketTemplate() {
        return mav("racket/manage");
    }

	@Override
	public ResponseEntity<String> delete(Principal principal, Long id) {
		rackets.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
