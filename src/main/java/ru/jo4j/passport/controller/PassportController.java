package ru.jo4j.passport.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.jo4j.passport.model.Passport;
import ru.jo4j.passport.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
        ;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Passport> findAll() {
        return passportService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passport create(@RequestBody Passport passport) {
        return passportService.create(passport);
    }

    @GetMapping("/{id}")
    public Passport findById(@PathVariable int id) {
        return passportService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Passport update (Passport passport) {
        return passportService.create(passport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        passportService.delete(id);
    }

    @GetMapping("/series")
    public List<Passport> getBySeries(@RequestParam(name = "series") String series) {
        return passportService.getBySeries(series);
    }

    @GetMapping("/getBeforeThreeMonth")
    @ResponseStatus(HttpStatus.OK)
    public List<Passport> getBeforeThreeMonth() {
        return passportService.getBeforeThreeMonth();
    }

    @GetMapping("/unavaliabe")
    public List<Passport> getUnavaliabe() {
        return passportService.getOverdue();
    }
}
