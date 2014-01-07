package com.racket.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.racket.commons.models.Racket;

/**
 * dto for the list of rackets owned/associated/followed, etc by a user
 * @author mbmartinez
 */
public class RacketeerInfo {

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

	public void convertAndSetRackets(List<Racket> rackets) {
		this.rackets = new ArrayList<RacketInfo>();
		for (Racket racket : rackets) {
			this.rackets.add(new RacketInfo(racket));
		}
	}

}
