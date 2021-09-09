package br.psc.guilherme.lol.data;

import br.psc.guilherme.lol.data.commands.FetchSummonerMatchData;
import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        FetchSummonerMatchData fetchSummonerMatchData = new FetchSummonerMatchData();
        CommandLine commandLine = new CommandLine(fetchSummonerMatchData);
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}
