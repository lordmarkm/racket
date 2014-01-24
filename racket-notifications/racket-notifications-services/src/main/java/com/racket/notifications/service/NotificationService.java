package com.racket.notifications.service;

import com.racket.commons.models.Transaction;
import com.racket.notifications.model.Notification;

public interface NotificationService {

    Notification compose(Transaction transaction);

}
