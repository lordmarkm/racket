package com.racket.commons.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.racket.commons.models.support.TransactionDetailType;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = "transaction_details")
public class TransactionDetail {

    @Id @GeneratedValue
    private long id;

    @Enumerated
    private TransactionDetailType type;

    /**
     * Short message appended after label
     */
    private String message;

    /**
     * Attachment label, probably entity name, used in the hyperlink
     */
    private String label;
    
    /**
     * Id of the attachment, possibly operator or commodity
     */
    @Column
    private long attachment;

    public TransactionDetail(TransactionDetailType type, long attachmentId, String attachmentLabel, String message) {
        this.type = type;
        this.attachment = attachmentId;
        this.label = attachmentLabel;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionDetailType getType() {
        return type;
    }

    public void setType(TransactionDetailType type) {
        this.type = type;
    }

    public long getAttachment() {
        return attachment;
    }

    public void setAttachment(long attachment) {
        this.attachment = attachment;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
