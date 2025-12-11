package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.Country;
import com.edaakyil.java.lib.data.repository.ICrudRepository;

public interface ICountryRepository extends ICrudRepository<Country, Long> {
    Iterable<Country> findByName(String name);
    Country updateCountry(Country country);
}
