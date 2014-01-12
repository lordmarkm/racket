package com.racket.commons.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.racket.commons.models.RacketCommodity;

/**
 * @author Mark
 */
public interface RacketCommodityService extends JpaRepository<RacketCommodity, Long> {

	@Query("from RacketCommodity c where c.racket.id = ?1")
	List<RacketCommodity> findByRacketId(Long racketId);

	@Query("from RacketCommodity c where c.racket.id = ?1")
	List<RacketCommodity> findByRacketId(Long racketId, Pageable page);

}
