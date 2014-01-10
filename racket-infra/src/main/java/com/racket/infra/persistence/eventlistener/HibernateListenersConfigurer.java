package com.racket.infra.persistence.eventlistener;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * testing only
 * @author mbmartinez
 * from http://deepintojee.wordpress.com/2012/02/05/spring-managed-event-listeners-with-jpa/
 */
@Component
public class HibernateListenersConfigurer {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private PreInsertEventListener preInsertEventListener;

    @PostConstruct
    public void registerListeners() {
        HibernateEntityManagerFactory hemf = (HibernateEntityManagerFactory) entityManagerFactory;
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) hemf.getSessionFactory();
        EventListenerRegistry eventListenerRegistry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        eventListenerRegistry.prependListeners(EventType.PRE_INSERT, preInsertEventListener);
    }
}
