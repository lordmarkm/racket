package com.racket.notifications.service.custom;

import com.racket.commons.models.Transaction;
import com.racket.notifications.model.Notification;

/**
 * @author mbmartinez
 */
public interface  NotificationServiceCustom {

    Notification compose(Transaction transaction);

}
