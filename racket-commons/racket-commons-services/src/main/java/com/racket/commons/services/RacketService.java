package com.racket.commons.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.racket.commons.models.Racket;
import com.racket.commons.models.Racketeer;
import com.racket.commons.services.custom.RacketServiceCustom;

/**
 * Aggregate service for rental and retail
 * @author mbmartinez
 */
public interface RacketService extends JpaRepository<Racket, Long>, RacketServiceCustom  {

	List<Racket> findByRacketeer(Racketeer racketeer);
	Page<Racket> findByRacketeer(Racketeer racketeer, Pageable page);

}
