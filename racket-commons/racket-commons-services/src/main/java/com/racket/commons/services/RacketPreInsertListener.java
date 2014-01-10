package com.racket.commons.services;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

/**
 * @author mbmartinez
 */
@Component
public class RacketPreInsertListener implements PreInsertEventListener {

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        throw new RuntimeException("What!");
    }

}
