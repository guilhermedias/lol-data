package br.psc.guilherme.lol.data.commands;

import br.psc.guilherme.lol.data.client.RiotClient;
import br.psc.guilherme.lol.data.client.dto.matches.Match;
import br.psc.guilherme.lol.data.output.OutputRecord;
import br.psc.guilherme.lol.data.output.OutputWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import static java.util.stream.Collectors.toList;
import static picocli.CommandLine.Help.Visibility.ALWAYS;

@Component
@Command(name = "fetch")
public class FetchSummonerMatchData implements Callable<Integer> {
    private static final String DEFAULT_OUTPUT_FILE_NAME = "output.csv";
    private static final String DEFAULT_MATCH_COUNT = "100";
    private static final int SUCCESS_EXIT_CODE = 0;

    private final RiotClient riotClient;

    private final OutputWriter outputWriter;

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

    @Option(
            names = {"--output"},
            defaultValue = DEFAULT_OUTPUT_FILE_NAME,
            showDefaultValue = ALWAYS,
            paramLabel = "output",
            description = "The name of the output file.")
    private String outputFileName;

    @Autowired
    public FetchSummonerMatchData(RiotClient riotClient, OutputWriter outputWriter) {
        this.riotClient = riotClient;
        this.outputWriter = outputWriter;
    }

    @Override
    public Integer call() {
        String summonerId = riotClient.getSummonerIdByName(summonerName, apiToken);

        Collection<String> matchIds =
                riotClient.getMatchIdsBySummonerId(summonerId, matchCount, apiToken);

        Collection<Match> matches = getMatches(matchIds);

        List<OutputRecord> playerMatchRecords = mapMatchesToOutputRecords(matches);

        outputWriter.writeOutput(playerMatchRecords, outputFileName);

        return SUCCESS_EXIT_CODE;
    }

    private List<OutputRecord> mapMatchesToOutputRecords(Collection<Match> matches) {
        return matches.stream()
                .flatMap(match ->
                        match.info().participants().stream()
                                .filter(participant -> participant.summonerName().equals(summonerName))
                                .map(participant -> new OutputRecord(match, participant)))
                .collect(toList());
    }

    private List<Match> getMatches(Collection<String> matchIds) {
        return matchIds.stream()
                .map(matchId -> {
                    respectTheApiRateLimit();

                    System.out.printf("Fetching data from match %s%n", matchId);
                    return riotClient.getMatchById(matchId, apiToken);
                })
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
