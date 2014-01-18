package com.racket.commons.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author mbmartinez
 */
@Embeddable
public class RetailDetails {

    /**
     * Amount in stock, though how this number is used is up to the user
     */
    @Column
    private int amount = 0;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
