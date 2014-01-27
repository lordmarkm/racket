package com.racket.commons.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = Transaction.table)
public class Transaction {

    public static final String table = "transactions";

    public static final String FIELD_DATE = "date";

    @Id @GeneratedValue
    private long id;

    @Column
    private BigDecimal value;

    @Column
    private String message;

    @ManyToOne(optional = false)
    private Racket racket;
    
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")    
    private DateTime date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TransactionDetail> details;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TransactionAnnotation> annotations;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public List<TransactionDetail> getDetails() {
        if(details == null){
        	this.details = new ArrayList<TransactionDetail>();
        }
        return details;
    }

    public void setDetails(List<TransactionDetail> details) {
        this.details = details;
    }

    public List<TransactionAnnotation> getAnnotations() {
        if(annotations == null) {
        	this.annotations = new ArrayList<TransactionAnnotation>();
        }
        return  annotations;
    }

    public void setAnnotations(List<TransactionAnnotation> annotations) {
        this.annotations = annotations;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

    public Racket getRacket() {
        return racket;
    }

    public void setRacket(Racket racket) {
        this.racket = racket;
    }

}
