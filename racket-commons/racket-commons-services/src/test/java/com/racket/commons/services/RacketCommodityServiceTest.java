package com.racket.commons.services;

import static org.junit.Assert.*;

import java.util.Collections;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.racket.commons.models.Racket;
import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.support.CommodityType;
import com.racket.commons.services.config.RacketCommonsServicesConfig;
import com.racket.infra.persistence.config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RacketCommonsServicesConfig.class, PersistenceConfig.class, TestConfig.class})
public class RacketCommodityServiceTest {

	@Resource
	private RacketService rackets;
	
	@Resource
	private RacketCommodityService commodities;
	
	@Test
	public void testFindLatest() {
//		Racket r = new Racket();
//		r.setName("nem");
//		r.setDescription("desc");
//		r.setCommodities(Collections.EMPTY_SET);
//		r = rackets.save(r);
//
//		RacketCommodity c1 = new RacketCommodity();
//		c1.setRacket(r);
//		c1.setName("c1");
//		c1.setType(CommodityType.RENTAL);
//		r.getCommodities().add(c1);
//
//		RacketCommodity c2 = new RacketCommodity();
//		c2.setRacket(r);
//		c2.setName("c2");
//		c2.setType(CommodityType.RETAIL);
//		r.getCommodities().add(c2);
//		
//		rackets.save(r);
//
//		assertEquals(commodities.findByRacketId(r.getId(), new PageRequest(0, 1, Direction.DESC, "id")).get(0).getName(), "c2");
	}
	
}
