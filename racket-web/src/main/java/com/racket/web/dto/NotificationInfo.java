package com.racket.web.dto;

import com.racket.notifications.model.Notification;

/**
 * @author mbmartinez
 */
public class NotificationInfo {

    private Notification notif;

    public NotificationInfo(Notification notif) {
        this.notif = notif;
    }
    
    public long getId() {
        return notif.getId();
    }

    public String getMessage() {
        return notif.getMessage();
    }

    public String getRacketName() {
        return notif.getRacket().getName();
    }

    public String toString() {
        return notif.toString();
    }
    
}
