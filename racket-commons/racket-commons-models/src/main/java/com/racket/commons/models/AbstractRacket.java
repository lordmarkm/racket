package com.racket.commons.models;

import java.util.Set;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractRacket extends AbstractEntity {

    @ManyToOne
    private Racketeer racketeer;

    @OneToMany
    private Set<RacketAssociation> associations;

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
