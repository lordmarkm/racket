package com.racket.commons.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.commons.models.Racket;
import com.racket.commons.models.Transaction;

/**
 * @author mbmartinez
 */
public interface TransactionService extends JpaRepository<Transaction, Long> {

    List<Transaction> findByRacket(Racket racket, Pageable pageRequest);

}
