package com.racket.commons.models;

import java.util.Set;

import com.baldy.commons.models.Commodity;

/**
 * @author mbmartinez
 */
public interface Racket {

    public long getId();
    public String getName();
    public String getDescription();
    public Racketeer getRacketeer();
    public Set<? extends Commodity> getCommodities();
    public Set<RacketAssociation> getAssociations();

}
