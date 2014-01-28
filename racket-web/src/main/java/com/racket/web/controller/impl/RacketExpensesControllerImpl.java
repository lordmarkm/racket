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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.baldy.commons.web.controller.GenericController;
import com.racket.commons.models.Expense;
import com.racket.commons.models.Racket;
import com.racket.commons.models.Racketeer;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.models.support.TransactionDetailType;
import com.racket.commons.services.ExpenseService;
import com.racket.commons.services.RacketService;
import com.racket.commons.services.RacketeerService;
import com.racket.notifications.model.Notification;
import com.racket.notifications.service.NotificationService;
import com.racket.web.controller.RacketExpensesController;
import com.racket.web.dto.ExpenseForm;
import com.racket.web.dto.NotificationInfo;

/**
 * @author mbmartinez
 */
@Component
public class RacketExpensesControllerImpl extends GenericController implements RacketExpensesController {

    private static Logger log = LoggerFactory.getLogger(RacketExpensesControllerImpl.class);

    @Resource
    private ExpenseService expenses;

    @Resource
    private RacketService rackets;

    @Resource
    private RacketeerService racketeers;

    @Resource
    private NotificationService notifs;

    @Override
    public ResponseEntity<List<String>> getExpenseClassifications(Principal principal, @PathVariable long id) {
        Racket racket = rackets.findOne(id);
        return new ResponseEntity<List<String>>(racket.getExpenseClassifications(), HttpStatus.OK);
    }
    
    @Override
    public  ResponseEntity<NotificationInfo> newExpense(Principal principal, @PathVariable long id, @RequestBody @Valid ExpenseForm form) {
        log.debug("New expense. user={}, racket={}, expense={}", name(principal), form);

        Racket racket = rackets.findOne(id);

        Expense expense = form.toExpense();
        expense.setRacket(racket);

        Transaction transaction = expenses.newExpense(expense);

        Racketeer operator = racketeers.findByUsername(principal.getName());
        TransactionDetail operatorDetail = new TransactionDetail(TransactionDetailType.OPERATOR_ID, operator.getId(), "Operator", principal.getName());
        transaction.getDetails().add(operatorDetail);
        racket.getTransactions().add(transaction);

        if (!racket.getExpenseClassifications().contains(expense.getClassification())) {
            racket.getExpenseClassifications().add(expense.getClassification());
        }

        rackets.save(racket);
        
        Notification notif = notifs.compose(transaction);
        NotificationInfo dto = new NotificationInfo(notif);

        return new ResponseEntity<NotificationInfo>(dto, HttpStatus.OK);
    }

}
