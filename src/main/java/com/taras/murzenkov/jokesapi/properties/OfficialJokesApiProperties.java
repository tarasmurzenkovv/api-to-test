package com.taras.murzenkov.jokesapi.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "official.jokes.api")
@Getter
@Setter
public class OfficialJokesApiProperties {
    private String host;
}
