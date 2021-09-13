package ru.jo4j.passport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jo4j.passport.model.Passport;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Integer> {

    Passport getById(Integer id);
    List<Passport> getBySeries(String series);
    List<Passport> getByDateBefore(LocalDate expirationDate);
}
