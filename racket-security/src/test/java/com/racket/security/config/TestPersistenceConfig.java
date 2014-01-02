package com.racket.security.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.racket.infra.persistence.config.CommonsPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, CommonsPersistenceConfig.class})
public class TestPersistenceConfig {

    @Test
    public void testConfig() {
        //
    }
    
}
