package com.racket.commons.services.custom;

import com.racket.commons.models.Expense;
import com.racket.commons.models.Transaction;

/**
 * @author mbmartinez
 */
public interface ExpenseServiceCustom {

    Transaction newExpense(Expense expense);

}
