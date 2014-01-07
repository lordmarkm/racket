package com.racket.commons.models;

import java.util.Set;

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

    @OneToMany
    private Set<RacketAssociation> associations;

    @OneToMany
    private Set<RacketCommodity> commodities;

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

}
