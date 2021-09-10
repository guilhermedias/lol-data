package br.psc.guilherme.lol.data.client;

import br.psc.guilherme.lol.data.client.dto.Summoner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

import static java.lang.String.format;

@Component
public class RiotClient {
    private static final String GET_SUMMONER_BY_NAME = "/lol/summoner/v4/summoners/by-name/%s";
    private static final String GET_MATCH_IDS_BY_SUMMONER_ID = "/lol/match/v5/matches/by-puuid/%s/ids?count=%d";
    private static final String API_TOKEN = "X-Riot-Token";

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final String platformBaseUrl;
    private final String regionBaseUrl;

    @Autowired
    public RiotClient(
            OkHttpClient httpClient,
            ObjectMapper objectMapper,
            @Value("${riot.client.platform.base.url}") String platformBaseUrl,
            @Value("${riot.client.region.base.url}") String regionBaseUrl) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
        this.platformBaseUrl = platformBaseUrl;
        this.regionBaseUrl = regionBaseUrl;
    }

    public String getSummonerIdByName(String summonerName, String apiToken) {
        String url = buildSummonerByNameUrl(summonerName);

        Request request = new Request.Builder()
                .url(url)
                .addHeader(API_TOKEN, apiToken)
                .get()
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            TypeReference<Summoner> responseType = new TypeReference<>() {
            };
            Summoner summoner = readResponse(response, responseType);
            return summoner.getSummonerId();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to retrieve summoner data.");
        }
    }

    public Collection<String> getMatchIdsBySummonerId(String summonerId, int matchCount, String apiToken) {
        String url = buildMatchIdsBySummonerIdUrl(summonerId, matchCount);

        Request request = new Request.Builder()
                .url(url)
                .addHeader(API_TOKEN, apiToken)
                .get()
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            TypeReference<Collection<String>> responseType = new TypeReference<>() {
            };
            return readResponse(response, responseType);
        } catch (Exception exception) {
            throw new RuntimeException("Failed to retrieve match IDs.");
        }
    }

    private String buildSummonerByNameUrl(String summonerName) {
        String path = format(GET_SUMMONER_BY_NAME, summonerName);
        return platformBaseUrl + path;
    }

    private String buildMatchIdsBySummonerIdUrl(String summonerId, int matchCount) {
        String path = format(GET_MATCH_IDS_BY_SUMMONER_ID, summonerId, matchCount);
        return regionBaseUrl + path;
    }

    private <T> T readResponse(Response response, TypeReference<T> responseType) throws IOException {
        return objectMapper.readValue(response.body().string(), responseType);
    }
}
