package br.psc.guilherme.lol.data.commands;

import br.psc.guilherme.lol.data.client.RiotClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Component
@Command(name = "fetch")
public class FetchSummonerMatchData implements Callable<Integer> {
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

    @Autowired
    public FetchSummonerMatchData(RiotClient riotClient) {
        this.riotClient = riotClient;
    }

    @Override
    public Integer call() {
        String summonerId = riotClient.getSummonerIdByName(summonerName, apiToken);
        System.out.println(summonerId);
        return SUCCESS_EXIT_CODE;
    }
}
