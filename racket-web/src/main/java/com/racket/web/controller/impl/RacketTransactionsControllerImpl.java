package com.racket.web.controller.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.google.common.collect.Lists;
import com.racket.commons.models.Racket;
import com.racket.commons.models.Racketeer;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionAnnotation;
import com.racket.commons.services.RacketService;
import com.racket.commons.services.RacketeerService;
import com.racket.commons.services.TransactionService;
import com.racket.notifications.model.Notification;
import com.racket.web.controller.RacketTransactionsController;
import com.racket.web.dto.NotificationInfo;
import com.racket.web.dto.TransactionAnnotationInfo;
import com.racket.web.dto.TransactionInfo;
import com.racket.web.forms.AnnotationForm;

/**
 * 
 * @author mbmartinez
 *
 */
@Component
public class RacketTransactionsControllerImpl extends GenericController implements RacketTransactionsController {

    @Resource
    private RacketService rackets;

    @Resource
    private RacketeerService racketeers;

    @Resource
    private TransactionService transactions;

    @Override
    public ModelAndView template(Principal principal) {
        return mav("racket/transactions");
    }

    @Override
    public ResponseEntity<List<TransactionInfo>> getLatestForRacket(Principal principal, @PathVariable Long id,
            @PathVariable int start, @PathVariable int end) {

        Racket racket = rackets.findOne(id);

        Sort sort = new Sort(Direction.DESC, Transaction.FIELD_DATE);
        Pageable pageRequest = new PageRequest(start, end, sort);

        List<TransactionInfo> dtos = Lists.newArrayList();
        for (Transaction transaction : transactions.findByRacket(racket, pageRequest)) {
            dtos.add(new TransactionInfo(transaction));
        }

        return new ResponseEntity<List<TransactionInfo>>(dtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TransactionAnnotationInfo> addAnnotation(Principal principal, @PathVariable Long id,
            @RequestBody @Valid AnnotationForm form) {

        Racketeer author = racketeers.findByUsername(name(principal));
        
        Transaction transaction = transactions.findOne(id);
        TransactionAnnotation annotation = form.toAnnotation();
        annotation.setAuthor(author);
        transaction.getAnnotations().add(annotation);
        transactions.save(transaction);

        return new ResponseEntity<TransactionAnnotationInfo>(new TransactionAnnotationInfo(annotation), HttpStatus.OK);
    }

}
