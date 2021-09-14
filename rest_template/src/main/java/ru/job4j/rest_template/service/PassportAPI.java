package ru.job4j.rest_template.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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

    public Passport add(Passport passport) {
        return client.postForEntity(
                url, passport, Passport.class
        ).getBody();
    }

    public boolean replace(String id, Passport passport) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.PUT,
                new HttpEntity<>(passport),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public List<Passport> findBySeries(String series) {
        return getList(String.format(
                "%s/series?series=%s", url, series
        ));
    }

    public List<Passport> getBeforeThreeMonth() {
        return getList(String.format(
                "%s/getBeforeThreeMonth", url
        ));
    }

    public List<Passport> getUnavaliabe() {
        return getList(String.format(
                "%s/unavaliabe", url
        ));
    }

    public boolean delete(String id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }



    public Passport findById(String id) {
        return client.getForEntity(
                String.format("%s/getById?id=%s", url, id),
                Passport.class
        ).getBody();
    }









    public List<Passport> getList(String url) {
        List<Passport> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
