package com.taras.murzenkov.jokesapi.services;

import com.google.common.collect.Lists;
import com.taras.murzenkov.jokesapi.clients.JokeClient;
import com.taras.murzenkov.jokesapi.dto.JokeDto;
import com.taras.murzenkov.jokesapi.dto.JokeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class JokesService {
    private final JokeClient jokeClient;

    public List<JokeDto> getJokes(Integer numberToFetch) {
        if (numberToFetch == null) {
            numberToFetch = 5;
        }
        if (numberToFetch < 0 || numberToFetch > 100) {
            throw new IllegalArgumentException("Number must be between 0 and 100");
        }

        var jokesInBatches = Lists.partition(Stream.of(1, numberToFetch).toList(), 10);

        return jokesInBatches.parallelStream()
                .map(jokeClient::getJokes)
                .flatMap(Collection::stream)
                .map(joke ->
                        new JokeDto(
                                joke.getId(), JokeType.GENERAL, joke.getSetup(), joke.getPunchline()
                        )
                ).toList();
    }
}
