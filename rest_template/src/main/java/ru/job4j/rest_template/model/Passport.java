package ru.job4j.rest_template.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Passport {

    private Integer id;
    private String series;
    private String num;
    private LocalDate date;
}
