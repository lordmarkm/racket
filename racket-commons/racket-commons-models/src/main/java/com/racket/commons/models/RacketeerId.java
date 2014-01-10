package com.racket.commons.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RacketeerId {

    @Column
    private long id;
    
    @Column
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
