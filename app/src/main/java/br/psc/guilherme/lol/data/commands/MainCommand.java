package br.psc.guilherme.lol.data.commands;

import br.psc.guilherme.lol.data.commands.fetch.FetchCommand;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Component
@Command(name = "lol-data",
        subcommands = {
                FetchCommand.class
        })
public class MainCommand {
}
