package br.psc.guilherme.lol.data.commands;

import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Component
@Command(name = "lol-data",
        subcommands = {
                FetchSummonerMatchData.class
        })
public class MainCommand {
}
