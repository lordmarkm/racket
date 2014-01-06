package com.racket.web.dto;

import com.racket.commons.models.RacketGroup;

/**
 * dto for racket group
 * @author mbmartinez
 */
public class RacketGroupInfo {

    private RacketGroup racketGroup;

    public RacketGroupInfo(RacketGroup racketGroup) {
        this.racketGroup = racketGroup;
    }

    public String getName() {
        return racketGroup.getName();
    }

    public String getDescription() {
        return racketGroup.getDescription();
    }

    public long getId() {
        return racketGroup.getId();
    }

}
