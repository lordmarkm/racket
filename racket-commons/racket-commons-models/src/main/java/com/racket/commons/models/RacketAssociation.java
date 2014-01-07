package com.racket.commons.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.racket.commons.models.support.RacketAuthority;

/**
 * @author mbmartinez
 * For people (employees or business partners) who have limited rights to a racket
 */
@Entity
@Table(name = RacketAssociation.table)
public class RacketAssociation {

    public static final String table = "associations";

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Racketeer racketeer;

    @Enumerated
    private RacketAuthority authority;

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

    public RacketAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(RacketAuthority authority) {
        this.authority = authority;
    }

}
