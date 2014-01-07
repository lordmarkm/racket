package com.racket.web.forms;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.core.style.ToStringCreator;

import com.racket.commons.models.Racket;

/**
 * @author mbmartinez
 */
public class RacketForm {

    private Long id;

    @NotBlank
    private String name;

    private String description;

    public RacketForm() {
        //
    }
    
    public Racket toRacket() {
        Racket racket = new Racket();
        if (null != id) racket.setId(id);
        racket.setName(name);
        racket.setDescription(description);
        
        return racket;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("name", name)
            .append("desc", description)
            .toString();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
