package br.psc.guilherme.lol.data.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class RiotClient {
    private static final String GET_SUMMONER_BY_NAME = "/lol/summoner/v4/summoners/by-name/%s";
    private static final String API_TOKEN = "X-Riot-Token";

    private final OkHttpClient httpClient;

    private final String platformBaseUrl;

    @Autowired
    public RiotClient(OkHttpClient httpClient,
                      @Value("${riot.client.platform.base.url}") String platformBaseUrl) {
        this.httpClient = httpClient;
        this.platformBaseUrl = platformBaseUrl;
    }

    public String getSummonerIdByName(String summonerName) {
        String url = buildSummonerByNameUrl(summonerName);

        Request request = new Request.Builder()
                .url(url)
                .addHeader(API_TOKEN, "FAKE_TOKEN")
                .get()
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to retrieve summoner data.");
        }

    }

    private String buildSummonerByNameUrl(String summonerName) {
        String path = format(GET_SUMMONER_BY_NAME, summonerName);
        return platformBaseUrl + path;
    }
}
