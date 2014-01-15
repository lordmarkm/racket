package com.racket.commons.models;

import javax.persistence.Column;

/**
 * @author mbmartinez
 */
public class RetailDetails {

    /**
     * Amount in stock, though how this number is used is up to the user
     */
    @Column
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
