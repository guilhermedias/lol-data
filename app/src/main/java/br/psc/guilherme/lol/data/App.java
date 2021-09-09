package br.psc.guilherme.lol.data;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("br.psc.guilherme.lol.data");

        CommandLine commandLine = applicationContext.getBean(CommandLine.class);

        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}
