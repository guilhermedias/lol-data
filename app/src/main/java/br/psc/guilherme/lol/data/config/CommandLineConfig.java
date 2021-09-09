package br.psc.guilherme.lol.data.config;

import br.psc.guilherme.lol.data.commands.MainCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Configuration
public class CommandLineConfig {
    @Bean
    public CommandLine commandLine(MainCommand mainCommand, IFactory commandFactory) {
        return new CommandLine(mainCommand, commandFactory);
    }
}
