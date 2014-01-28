package com.racket.commons.services.custom.impl;

import javax.annotation.Resource;

import com.racket.commons.models.Expense;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionDetail;
import com.racket.commons.services.ExpenseService;
import com.racket.commons.services.custom.ExpenseServiceCustom;

public class ExpenseServiceCustomImpl implements ExpenseServiceCustom {

    @Resource
    private ExpenseService expenses;

    @Override
    public Transaction newExpense(Expense expense) {
        expenses.save(expense);

        Transaction transaction = new Transaction();
        transaction.setValue(expense.getValue().negate());
        transaction.setDate(expense.getDate());
        transaction.setMessage(expense.getValue() + " paid for " + expense.getDescription());
        transaction.setRacket(expense.getRacket());

        TransactionDetail expenseClassDetail = new TransactionDetail();
        expenseClassDetail.setLabel("Expense classification");
        expenseClassDetail.setMessage(expense.getClassification());
        transaction.getDetails().add(expenseClassDetail);
        
        return transaction;
    }

}
