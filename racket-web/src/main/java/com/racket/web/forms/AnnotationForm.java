package com.racket.web.forms;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.racket.commons.models.TransactionAnnotation;

/**
 * 
 * @author mbmartinez
 *
 */
public class AnnotationForm {

    @NotEmpty
    private String description;

    private BigDecimal value;

    public TransactionAnnotation toAnnotation() {
        TransactionAnnotation annotation = new TransactionAnnotation();
        annotation.setTitle(description);
        annotation.setValue(value);
        annotation.setDate(DateTime.now());
        return annotation;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
