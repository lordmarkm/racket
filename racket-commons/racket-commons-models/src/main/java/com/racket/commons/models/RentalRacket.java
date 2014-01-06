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
@Table(name = RentalRacket.table)
public class RentalRacket extends AbstractRacket implements Racket {

    public static final String table = "rental_racket";

    @OneToMany
    private Set<RacketRentable> rentables;

    @Override
    public Set<? extends Commodity> getCommodities() {
        return rentables;
    }

    public Set<RacketRentable> getRentables() {
        return rentables;
    }

    public void setRentables(Set<RacketRentable> rentables) {
        this.rentables = rentables;
    }

}
