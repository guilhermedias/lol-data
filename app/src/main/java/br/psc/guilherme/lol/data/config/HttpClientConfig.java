package br.psc.guilherme.lol.data.config;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {
    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }
}
