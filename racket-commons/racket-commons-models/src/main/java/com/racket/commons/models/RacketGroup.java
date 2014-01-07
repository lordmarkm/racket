package com.racket.commons.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = RacketGroup.table)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RacketGroup extends AbstractEntity {

    public static final String table = "racket_groups";

    @ManyToOne
    private Racketeer author;

    @ManyToMany
    private Set<Racket> rackets;

    public Racketeer getAuthor() {
        return author;
    }

    public void setAuthor(Racketeer author) {
        this.author = author;
    }

    public Set<Racket> getRackets() {
        return rackets;
    }

    public void setRackets(Set<Racket> rackets) {
        this.rackets = rackets;
    }

}
