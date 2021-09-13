package ru.jo4j.passport.service;

import org.springframework.stereotype.Service;
import ru.jo4j.passport.model.Passport;
import ru.jo4j.passport.repository.PassportRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public List<Passport> findAll() {
        return StreamSupport.stream(
                passportRepository.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    public Passport findById(int id) {
        return passportRepository.getById(id);
    }

    public Passport update (Passport passport) {
        return passportRepository.save(passport);
    }

    public Passport create(Passport passport) {
        return passportRepository.save(passport);
    }

    public void delete(int id) {
        passportRepository.deleteById(id);
    }

    public List<Passport> getBySeries(String series) {
        return passportRepository.getBySeries(series);
    }

    public List<Passport> getBeforeThreeMonth() {
        LocalDate date = LocalDate.now();
        date = date.plusMonths(3);
        return passportRepository.getByDateBefore(date);
    }

    public List<Passport> getOverdue() {
        return passportRepository.getByDateBefore(LocalDate.now().minusDays(1));
    }
}
