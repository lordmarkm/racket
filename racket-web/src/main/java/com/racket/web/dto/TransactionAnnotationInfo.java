package com.racket.web.dto;

import java.math.BigDecimal;

import com.racket.commons.models.TransactionAnnotation;

/**
 * 
 * @author mbmartinez
 *
 */
public class TransactionAnnotationInfo {

    private TransactionAnnotation transactionAnnotation;
    
    public TransactionAnnotationInfo(TransactionAnnotation transactionAnnotation) {
        this.transactionAnnotation = transactionAnnotation;
    }

    public BigDecimal getValue() {
        return transactionAnnotation.getValue();
    }

    public String getTitle() {
        return transactionAnnotation.getTitle();
    }

    public String getText() {
        return transactionAnnotation.getText();
    }

    public String toString() {
        return transactionAnnotation.toString();
    }

}
