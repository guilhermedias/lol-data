package br.psc.guilherme.lol.data.commands;

import br.psc.guilherme.lol.data.client.RiotClient;
import br.psc.guilherme.lol.data.client.dto.matches.Match;
import br.psc.guilherme.lol.data.client.dto.matches.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Collection;
import java.util.concurrent.Callable;

import static picocli.CommandLine.Help.Visibility.ALWAYS;

@Component
@Command(name = "fetch")
public class FetchSummonerMatchData implements Callable<Integer> {
    private static final String DEFAULT_MATCH_COUNT = "100";
    private static final int SUCCESS_EXIT_CODE = 0;

    private final RiotClient riotClient;

    @Parameters(
            index = "0",
            paramLabel = "summoner-name",
            description = "The summoner name.")
    private String summonerName;

    @Option(
            names = {"--api-token"},
            required = true,
            paramLabel = "api-token",
            description = "The Riot API token.")
    private String apiToken;

    @Option(
            names = {"--match-count"},
            defaultValue = DEFAULT_MATCH_COUNT,
            showDefaultValue = ALWAYS,
            paramLabel = "match-count",
            description = "The number of matches to retrieve.")
    private Integer matchCount;

    @Autowired
    public FetchSummonerMatchData(RiotClient riotClient) {
        this.riotClient = riotClient;
    }

    @Override
    public Integer call() {
        String summonerId = riotClient.getSummonerIdByName(summonerName, apiToken);

        Collection<String> matchIds =
                riotClient.getMatchIdsBySummonerId(summonerId, matchCount, apiToken);

        String firstMatchId = matchIds
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to retrieve match IDs."));

        Match match = riotClient.getMatchById(firstMatchId, apiToken);

        Integer detectorWards = match.info().participants()
                .stream()
                .filter(participant -> participant.summonerName().equals("Gadias"))
                .map(Participant::totalDamageDealtToChampions)
                .findFirst()
                .orElse(-1);

        System.out.println(detectorWards);

        return SUCCESS_EXIT_CODE;
    }
}
