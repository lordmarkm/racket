package com.racket.commons.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

}
