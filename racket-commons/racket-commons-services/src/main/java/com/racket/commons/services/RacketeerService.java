package com.racket.commons.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.racket.commons.models.Racketeer;

public interface RacketeerService extends JpaRepository<Racketeer, Long> {

	@Query("from Racketeer r where r.account.username = ?1")
	Racketeer findByUsername(String username);

}
