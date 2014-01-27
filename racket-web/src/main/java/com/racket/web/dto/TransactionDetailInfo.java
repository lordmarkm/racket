package com.racket.web.dto;

import com.racket.commons.models.TransactionDetail;
import com.racket.commons.models.support.TransactionDetailType;

/**
 * 
 * @author mbmartinez
 *
 */
public class TransactionDetailInfo {

    private TransactionDetail transactionDetail;
    
    public TransactionDetailInfo(TransactionDetail transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public long getId() {
        return transactionDetail.getId();
    }

    public TransactionDetailType getType() {
        return transactionDetail.getType();
    }

    public long getAttachment() {
        return transactionDetail.getAttachment();
    }

    public String getLabel() {
        return transactionDetail.getLabel();
    }

    public String getMessage() {
        return transactionDetail.getMessage();
    }

    public String toString() {
        return transactionDetail.toString();
    }
    
}
