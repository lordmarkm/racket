package com.racket.infra.persistence.eventlistener;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * testing only
 * @author mbmartinez
 */
@Component
public class RacketPreInsertEventListener implements PreInsertEventListener {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(RacketPreInsertEventListener.class);
    
    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        log.info("******* About to persist class={}*******", event.getEntity().getClass());
        
        return false;
    }

}
