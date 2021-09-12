package br.psc.guilherme.lol.data.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Summoner(
        @JsonProperty("puuid") String id) {
}
