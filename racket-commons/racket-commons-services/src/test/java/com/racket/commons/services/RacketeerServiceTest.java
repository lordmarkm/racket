package com.racket.commons.services;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.baldy.commons.security.models.Account;
import com.baldy.commons.security.services.AccountService;
import com.baldy.commons.security.services.Roles;
import com.racket.commons.models.AccountInfo;
import com.racket.commons.models.Racketeer;
import com.racket.commons.models.RacketeerId;
import com.racket.commons.services.config.RacketCommonsServicesConfig;
import com.racket.infra.persistence.config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RacketCommonsServicesConfig.class, PersistenceConfig.class, TestConfig.class})
@Transactional
public class RacketeerServiceTest {

	private static Logger log = LoggerFactory.getLogger(RacketeerServiceTest.class);
	
	@Resource
	private RacketeerService racketeers;
	
	@Resource
	private AccountService accounts;
	
	@Before
	public void clear() {
		accounts.deleteAll();
		racketeers.deleteAll();
	}
	
	@Test
	public void testConfig() {
		
	}
	
	@Test
	public void testCrud() {
		Account account = new Account();
		account.setAuthorities(Roles.ROLE_USER);
		account.setUsername("user");
		account.setPassword("pass");
		account = accounts.save(account);

		Racketeer racketeer = new Racketeer();
		racketeer.setAccount(account);
		
		RacketeerId rid = new RacketeerId();
		rid.setName("Mark");
		racketeer.setIds(Arrays.asList(rid));
		
		Racketeer saved = racketeers.save(racketeer);
		assertNotNull(saved);
		
		log.info("Saved racketeer={}", saved);
		
		log.info("After this there should be no pre-insert listeners called on Racketeer.");
		saved.setAccountInfo(new AccountInfo());
		racketeers.save(saved);
		
		assertNotNull(racketeers.findByUsername("user"));
		
	}
	
}
