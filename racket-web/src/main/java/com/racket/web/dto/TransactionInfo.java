package com.racket.web.dto;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.racket.commons.models.Transaction;
import com.racket.commons.models.TransactionAnnotation;
import com.racket.commons.models.TransactionDetail;

/**
 * 
 * @author mbmartinez
 *
 */
public class TransactionInfo {

    private Transaction transaction;

    public TransactionInfo(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getMessage() {
        return transaction.getMessage();
    }

    public DateTime getDate() {
        return transaction.getDate();
    }

    public List<TransactionDetailInfo> getDetails() {
        List<TransactionDetailInfo> dtos = Lists.newArrayList();
        for (TransactionDetail detail : transaction.getDetails()) {
            dtos.add(new TransactionDetailInfo(detail));
        }
        return dtos;
    }

    public List<TransactionAnnotationInfo> getAnnotations() {
        List<TransactionAnnotationInfo> dtos = Lists.newArrayList();
        for (TransactionAnnotation annotation : transaction.getAnnotations()) {
            dtos.add(new TransactionAnnotationInfo(annotation));
        }
        return dtos;
    }

    public long getId() {
        return transaction.getId();
    }

    public BigDecimal getValue() {
        return transaction.getValue();
    }

    public boolean equals(Object obj) {
        return transaction.equals(obj);
    }

    public String toString() {
        return transaction.toString();
    }

}
