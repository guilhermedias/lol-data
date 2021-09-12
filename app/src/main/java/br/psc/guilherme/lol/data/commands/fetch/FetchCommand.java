package br.psc.guilherme.lol.data.commands.fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static picocli.CommandLine.Help.Visibility.ALWAYS;

@Component
@Command(name = "fetch")
public class FetchCommand implements Callable<Integer> {
    private static final String DEFAULT_OUTPUT_FILE_NAME = "output.csv";
    private static final String DEFAULT_MATCH_COUNT = "100";
    private static final int SUCCESS_EXIT_CODE = 0;

    private final FetchService fetchService;

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
    public FetchCommand(FetchService fetchService) {
        this.fetchService = fetchService;
    }

    @Override
    public Integer call() {
        fetchService.fetchPlayerMatchData(summonerName, matchCount, outputFileName, apiToken);
        return SUCCESS_EXIT_CODE;
    }
}
