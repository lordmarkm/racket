package com.racket.web.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.racket.commons.models.Expense;

/**
 * @author mbmartinez
 */
public class ExpenseForm {

    @NotEmpty
    private String classification;

    @NotEmpty
    private String description;

    @NotNull
    private BigDecimal value;

    public Expense toExpense() {
        Expense expense = new Expense();
        expense.setClassification(classification);
        expense.setDate(DateTime.now());
        expense.setDescription(description);
        expense.setValue(value);
        return expense;
    }
    
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
