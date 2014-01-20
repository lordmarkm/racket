package com.racket.notifications.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Notification.table)
public class Notification {

    public static final String table = "notifications";

}
