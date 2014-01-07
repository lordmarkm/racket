package com.racket.commons.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.commons.models.Racket;
import com.racket.commons.models.Racketeer;

/**
 * Aggregate service for rental and retail
 * @author mbmartinez
 */
public interface RacketService extends JpaRepository<Racket, Long>  {

	Page<Racket> findByRacketeer(Racketeer racketeer, Pageable page);

}
