package com.taras.murzenkov.jokesapi.dto;

public record JokeDto(
        int id,
        JokeType type,
        String setup,
        String punchline
) {}

