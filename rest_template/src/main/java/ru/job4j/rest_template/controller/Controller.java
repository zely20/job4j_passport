package ru.job4j.rest_template.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.rest_template.model.Passport;
import ru.job4j.rest_template.service.PassportAPI;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final PassportAPI passportAPI;

    public Controller(PassportAPI passportAPI) {
        this.passportAPI = passportAPI;
    }

    @GetMapping
    public List<Passport> findAll() {
        return passportAPI.findAll();
    }
}
