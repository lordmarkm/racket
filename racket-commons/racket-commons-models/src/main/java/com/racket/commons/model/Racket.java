package com.racket.commons.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Racket.table)
public class Racket {

    public static final String table = "racket";

    private long id;

    private Racketeer racketeer;

    private List<RacketAssociation> associations;

}
