package com.racket.commons.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonsPersistenceConfig.class})
public class ConfigTest {

    @Before
    public void init() {

    }

    @Test
    public void testConfig() {
        //
    }
}
