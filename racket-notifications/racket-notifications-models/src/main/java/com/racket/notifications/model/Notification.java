package com.racket.notifications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.racket.commons.models.Racket;

@Entity
@Table(name = Notification.table)
public class Notification {

    public static final String table = "notifications";

    @Id @GeneratedValue
    private long id;

    @Column
    @Type(type = "text")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private Racket racket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Racket getRacket() {
        return racket;
    }

    public void setRacket(Racket racket) {
        this.racket = racket;
    }
    
}
