package com.racket.notifications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.racket.commons.models.Racket;
import com.racket.commons.models.Transaction;

@Entity
@Table(name = Notification.table)
public class Notification {

    public static final String table = "notifications";
    public static final String FIELD_DATE = "date";

    @Id @GeneratedValue
    private long id;

    @Column
    @Type(type = "text")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private Racket racket;

    @Column(name = FIELD_DATE)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")    
    private DateTime date;
    
    @OneToOne
    private Transaction transaction;

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

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

}
