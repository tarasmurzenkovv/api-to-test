package com.taras.murzenkov.jokesapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.taras.murzenkov.jokesapi.clients.JokeClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest(
        properties = {"official.jokes.api.host=localhost:8080"},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class JokesApiApplicationTests {
    private final WireMockServer wireMockServer = new WireMockServer();
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        stubFor(
                get(urlEqualTo("/api/v1/jokes?jokesNumber=10"))
                        .willReturn(
                                aResponse()
                                        .withStatus(200)
                                        .withHeader("Content-Type", "application/json")
                                        .withBody("""
                                                [
                                                    {
                                                        "id": 1,
                                                        "setup": "setup",
                                                        "punchline": "punchline"
                                                    }
                                                ]
                                                """)
                        )
        );
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void shouldFetchJokes() {
        String response = restTemplate.getForObject("http://localhost:" + port + "api/v1/jokes?jokesNumber=10", String.class);
    }
}
