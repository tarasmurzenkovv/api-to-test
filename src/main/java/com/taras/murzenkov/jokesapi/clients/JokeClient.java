package com.taras.murzenkov.jokesapi.clients;

import com.taras.murzenkov.jokesapi.properties.OfficialJokesApiProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JokeClient {
    private final OfficialJokesApiProperties officialJokesApiProperties;
    private final RestTemplate restTemplate;

    public List<OfficialRandJokeApiResponse> getJokes(List<Integer> batch) {
        return batch.stream().map(_ -> getJoke()).toList();
    }

    private OfficialRandJokeApiResponse getJoke() {
        return restTemplate.getForObject(officialJokesApiProperties.getHost(), OfficialRandJokeApiResponse.class);
    }

    @Getter
    @Setter
    public static class OfficialRandJokeApiResponse {
        private int id;
        private String setup;
        private String punchline;
    }
}
