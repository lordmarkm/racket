package com.racket.commons.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = Transaction.table)
public class Transaction {

    public static final String table = "transactions";

    @Column
    private String message;

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
        return details == null ? new ArrayList<TransactionDetail>() : details;
    }

    public void setDetails(List<TransactionDetail> details) {
        this.details = details;
    }

    public List<TransactionAnnotation> getAnnotations() {
        return annotations == null ? new ArrayList<TransactionAnnotation>() : annotations;
    }

    public void setAnnotations(List<TransactionAnnotation> annotations) {
        this.annotations = annotations;
    }

}
