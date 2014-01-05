package com.racket.commons.models;

import java.util.Set;

import com.baldy.commons.models.Commodity;

/**
 * @author mbmartinez
 */
public interface Racket {

    public Racketeer getRacketeer();
    public Set<Commodity> getCommodities();

}
