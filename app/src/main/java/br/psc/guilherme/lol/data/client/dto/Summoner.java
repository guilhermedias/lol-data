package br.psc.guilherme.lol.data.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Summoner {
    private final String summonerId;

    @JsonCreator
    public Summoner(@JsonProperty("puuid") String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerId() {
        return summonerId;
    }
}
