package br.psc.guilherme.lol.data.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "fetch")
public class FetchSummonerMatchData implements Callable<Integer> {
    private static final int SUCCESS_EXIT_CODE = 0;

    @Parameters(
            index = "0",
            paramLabel = "summoner-name",
            description = "The summoner name.")
    private String summonerName;

    @Override
    public Integer call() {
        System.out.println(summonerName);
        return SUCCESS_EXIT_CODE;
    }
}
