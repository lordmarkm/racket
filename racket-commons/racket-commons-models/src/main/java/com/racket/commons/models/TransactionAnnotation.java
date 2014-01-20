package com.racket.commons.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Annotation to a transaction, possibly a correction
 * @author mbmartinez
 */
@Entity
@Table(name = TransactionAnnotation.table)
public class TransactionAnnotation {

    public static final String table = "transaction_annotations";

    @Id @GeneratedValue
    private long id;

    /**
     * Add a number value here if value is added/subtracted to a transaction
     */
    @Column
    private BigDecimal value;

    /**
     * A desc for the text contained in this same annotation
     */
    @Column
    private String title;

    /**
     * General purpose annotation text, may be used for delivery address, tracking code, etc, etc
     */
    @Column
    @Type(type="text")
    private String text;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
