package br.psc.guilherme.lol.data.client.dto.matches;

import java.util.Collection;

public record Info(
        Integer gameDuration,
        Collection<Participant> participants) {
}
