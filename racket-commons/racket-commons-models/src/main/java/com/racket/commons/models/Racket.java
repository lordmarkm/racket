package com.racket.commons.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = Racket.table)
public class Racket extends AbstractEntity {

    public static final String table = "racket";

    @ManyToOne
    private Racketeer racketeer;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<RacketAssociation> associations;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<RacketCommodity> commodities;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @ElementCollection @CollectionTable(name = "racket_expense_classifications")
    private List<String> expenseClassifications;

    public Racketeer getRacketeer() {
        return racketeer;
    }

    public void setRacketeer(Racketeer racketeer) {
        this.racketeer = racketeer;
    }

    public Set<RacketAssociation> getAssociations() {
        return associations;
    }

    public void setAssociations(Set<RacketAssociation> associations) {
        this.associations = associations;
    }

    public Set<RacketCommodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(Set<RacketCommodity> commodities) {
        this.commodities = commodities;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<String> getExpenseClassifications() {
        if (this.expenseClassifications == null) {
            this.expenseClassifications = Lists.newArrayList();
        }
        return expenseClassifications;
    }

    public void setExpenseClassifications(List<String> expenseClassifications) {
        this.expenseClassifications = expenseClassifications;
    }

}
