package br.psc.guilherme.lol.data.commands.fetch;

import br.psc.guilherme.lol.data.client.RiotClient;
import br.psc.guilherme.lol.data.client.dto.matches.Match;
import br.psc.guilherme.lol.data.output.OutputRecord;
import br.psc.guilherme.lol.data.output.OutputWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class FetchService {
    private final RiotClient riotClient;

    private final OutputWriter outputWriter;

    @Autowired
    public FetchService(RiotClient riotClient, OutputWriter outputWriter) {
        this.riotClient = riotClient;
        this.outputWriter = outputWriter;
    }

    public void fetchPlayerMatchData(String summonerName, Integer matchCount, String outputFileName, String apiToken) {
        String summonerId = riotClient.getSummonerIdByName(summonerName, apiToken);

        Collection<String> matchIds =
                riotClient.getMatchIdsBySummonerId(summonerId, matchCount, apiToken);

        Collection<Match> matches = getMatches(matchIds, apiToken);

        List<OutputRecord> playerMatchRecords = mapMatchesToOutputRecords(matches, summonerName);

        outputWriter.writeOutput(playerMatchRecords, outputFileName);
    }

    private List<Match> getMatches(Collection<String> matchIds, String apiToken) {
        return matchIds.stream()
                .map(matchId -> {
                    respectTheApiRateLimit();

                    System.out.printf("Fetching data from match %s%n", matchId);
                    return riotClient.getMatchById(matchId, apiToken);
                })
                .collect(toList());
    }

    private List<OutputRecord> mapMatchesToOutputRecords(Collection<Match> matches, String summonerName) {
        return matches.stream()
                .flatMap(match ->
                        match.info().participants().stream()
                                .filter(participant -> participant.summonerName().equals(summonerName))
                                .map(participant -> new OutputRecord(match, participant)))
                .collect(toList());
    }

    private void respectTheApiRateLimit() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            throw new RuntimeException("Process interrupted.");
        }
    }
}
