package ukim.finki.mk.lab2emt.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab2emt.model.Country;
import ukim.finki.mk.lab2emt.repository.CountryRepository;
import ukim.finki.mk.lab2emt.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return this.countryRepository.save(country);
    }
}
