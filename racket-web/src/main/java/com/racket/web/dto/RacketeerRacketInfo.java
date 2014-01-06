package com.racket.web.dto;

import java.util.List;

/**
 * dto for the list of rackets owned/associated/followed, etc by a user
 * @author mbmartinez
 */
public class RacketeerRacketInfo {

    private List<RacketGroupInfo> racketGroups;
    private List<RacketInfo> rackets;

    public List<RacketGroupInfo> getRacketGroups() {
        return racketGroups;
    }

    public void setRacketGroups(List<RacketGroupInfo> racketGroups) {
        this.racketGroups = racketGroups;
    }

    public List<RacketInfo> getRackets() {
        return rackets;
    }

    public void setRackets(List<RacketInfo> rackets) {
        this.rackets = rackets;
    }

}
