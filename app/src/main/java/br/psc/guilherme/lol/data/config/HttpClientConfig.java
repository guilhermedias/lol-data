package br.psc.guilherme.lol.data.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Configuration
public class HttpClientConfig {
    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.setVisibility(objectMapper
                .getDeserializationConfig()
                .getDefaultVisibilityChecker()
                .withFieldVisibility(ANY));

        return objectMapper;
    }
}
