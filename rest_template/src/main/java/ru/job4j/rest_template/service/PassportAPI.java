package ru.job4j.rest_template.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.rest_template.model.Passport;

import java.util.Collections;
import java.util.List;

@Service
public class PassportAPI {

    @Value("${api-url}")
    private String url;

    private final RestTemplate client;

    public PassportAPI(RestTemplate client) {
        this.client = client;
    }

    public List<Passport> findAll() {
        List<Passport> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
