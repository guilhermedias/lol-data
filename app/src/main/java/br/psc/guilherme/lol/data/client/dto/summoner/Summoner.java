package br.psc.guilherme.lol.data.client.dto.summoner;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Summoner(
        @JsonProperty("puuid") String id) {
}
