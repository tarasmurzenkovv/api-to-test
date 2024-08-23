package com.taras.murzenkov.jokesapi.dto;

public enum JokeType {
    GENERAL("general");
    private final String type;

    JokeType(String general) {
        this.type = general;
    }
}