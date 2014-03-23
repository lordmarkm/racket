package com.racket.notifications.service.impl;

import javax.annotation.Resource;

import org.joda.time.DateTime;

import com.racket.commons.models.Transaction;
import com.racket.notifications.model.Notification;
import com.racket.notifications.service.NotificationService;
import com.racket.notifications.service.custom.NotificationServiceCustom;

/**
 * @author mbmartinez
 */
public class NotificationServiceCustomImpl implements NotificationServiceCustom {

    @Resource
    private NotificationService notifs;

    @Override
    public Notification compose(Transaction transaction) {

        Notification notif = new Notification();
        notif.setMessage(transaction.getMessage());
        notif.setRacket(transaction.getRacket());
        notif.setTransaction(transaction);
        notif.setDate(DateTime.now());

        return notifs.save(notif);
    }

}
