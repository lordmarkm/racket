package com.racket.commons.services;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.racket.commons.models.Racket;
import com.racket.commons.services.config.RacketCommonsServicesConfig;
import com.racket.infra.persistence.config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RacketCommonsServicesConfig.class, PersistenceConfig.class, TestConfig.class})
@Transactional
public class RacketServiceTest {

    @Resource
    private RacketService rackets;
    
    @Test
    public void testCrud() {
        Racket racket = new Racket();
        racket.setName("some name");
        racket.setDescription("some desc");
        Racket saved = rackets.save(racket);
        
        assertNotNull(saved);
    }
    
}
