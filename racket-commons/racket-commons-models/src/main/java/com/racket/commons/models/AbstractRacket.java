package com.racket.commons.models;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractRacket {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Racketeer racketeer;

    @OneToMany
    private Set<RacketAssociation> associations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

}
