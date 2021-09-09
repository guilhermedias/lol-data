package br.psc.guilherme.lol.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesConfigurer() {
        ClassPathResource resource = new ClassPathResource("application.properties");

        PropertySourcesPlaceholderConfigurer propertiesConfigurer =
                new PropertySourcesPlaceholderConfigurer();

        propertiesConfigurer.setLocation(resource);

        return propertiesConfigurer;
    }
}
