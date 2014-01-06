package com.racket.commons.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = RacketGroup.table)
public class RacketGroup {

    public static final String table = "racket_groups";

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Racketeer author;

    @ElementCollection
    private List<Long> rackets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Racketeer getAuthor() {
        return author;
    }

    public void setAuthor(Racketeer author) {
        this.author = author;
    }

    public List<Long> getRackets() {
        return rackets;
    }

    public void setRackets(List<Long> rackets) {
        this.rackets = rackets;
    }

}
