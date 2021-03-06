package com.racket.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.racket.web.dto.TransactionAnnotationInfo;
import com.racket.web.dto.TransactionInfo;
import com.racket.web.forms.AnnotationForm;

/**
 * 
 * @author mbmartinez
 *
 */
@Controller
@RequestMapping("/racket/transactions")
public interface RacketTransactionsController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    ModelAndView template(Principal principal);

    @ResponseBody
    @RequestMapping("/{id}/{start}/{end}")
    ResponseEntity<List<TransactionInfo>> getLatestForRacket(Principal principal, Long id, int start, int end);

    @ResponseBody
    @RequestMapping(value = "/annotations/add/{id}", method = RequestMethod.POST)
    ResponseEntity<TransactionAnnotationInfo> addAnnotation(Principal principal, Long id, @RequestBody AnnotationForm form);

}
