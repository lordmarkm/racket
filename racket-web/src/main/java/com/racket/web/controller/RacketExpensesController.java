package com.racket.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.racket.web.dto.ExpenseForm;
import com.racket.web.dto.NotificationInfo;

@Controller
@RequestMapping("/racket/expenses")
public interface RacketExpensesController {

    @RequestMapping(value = "/classifications/{id}")
    ResponseEntity<List<String>> getExpenseClassifications(Principal principal, long id);
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    ResponseEntity<NotificationInfo> newExpense(Principal principal, long id, ExpenseForm expense);

}
