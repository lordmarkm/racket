package com.racket.commons.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.commons.models.Expense;
import com.racket.commons.services.custom.ExpenseServiceCustom;

public interface ExpenseService extends JpaRepository<Expense, Long>, ExpenseServiceCustom {

}
