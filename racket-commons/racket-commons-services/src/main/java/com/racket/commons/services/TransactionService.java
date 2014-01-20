package com.racket.commons.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.commons.models.Transaction;

/**
 * @author mbmartinez
 */
public interface TransactionService extends JpaRepository<Transaction, Long> {

}
