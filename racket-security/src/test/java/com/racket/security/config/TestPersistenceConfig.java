package com.racket.security.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.racket.infra.persistence.config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, PersistenceConfig.class})
@Transactional
public class TestPersistenceConfig {

    @Test
    public void testConfig() {
        //
    }
    
}
