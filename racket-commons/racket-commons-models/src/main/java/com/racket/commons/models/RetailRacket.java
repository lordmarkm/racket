package com.racket.commons.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.baldy.commons.models.Commodity;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = RetailRacket.table)
public class RetailRacket extends AbstractRacket implements Racket {

    public static final String table = "retail_racket";

    @OneToMany
    private Set<RacketSellable> sellables;

    @Override
    public Set<? extends Commodity> getCommodities() {
        return sellables;
    }

    public Set<RacketSellable> getSellables() {
        return sellables;
    }

    public void setSellables(Set<RacketSellable> sellables) {
        this.sellables = sellables;
    }

}
