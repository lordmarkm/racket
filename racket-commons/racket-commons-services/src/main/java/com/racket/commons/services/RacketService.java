package com.racket.commons.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.commons.models.Racket;

/**
 * Aggregate service for rental and retail
 * @author mbmartinez
 */
public interface RacketService extends JpaRepository<Racket, Long>  {

}
