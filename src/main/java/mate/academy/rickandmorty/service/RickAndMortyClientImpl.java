package mate.academy.rickandmorty.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.ExternalHeroDto;
import mate.academy.rickandmorty.dto.external.ExternalHeroResponseDto;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RickAndMortyClientImpl implements ClientApi<ExternalHeroDto> {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";
    private static final String BY_ID = "%s/%d";
    private static final String BY_NAME = "%s?name=%s";
    private final ObjectMapper objectMapper;

    @Override
    public ExternalHeroDto getRandomHero(int randomNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = String.format(BY_ID, BASE_URL, randomNumber);
        HttpRequest httpRequest = initRequest(url);
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return objectMapper
                    .readValue(response.body(), ExternalHeroDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExternalHeroDto> findHeroesByName(String characterName) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = String.format(BY_NAME, BASE_URL, characterName);
        HttpRequest httpRequest = initRequest(url);
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return objectMapper
                    .readValue(response.body(), ExternalHeroResponseDto.class).result();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpRequest initRequest(String url) {
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
    }
}
