package com.taras.murzenkov.jokesapi.controllers;

import com.taras.murzenkov.jokesapi.dto.JokeDto;
import com.taras.murzenkov.jokesapi.services.JokesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jokes")
public class Jokes {

    private final JokesService jokesService;

    public Jokes(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @GetMapping
    public List<JokeDto> getJokes(@RequestParam Integer jokesNumber) {
        return jokesService.getJokes(jokesNumber);
    }
}
