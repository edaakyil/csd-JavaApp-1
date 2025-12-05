package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.City;
import com.edaakyil.java.lib.data.repository.ICrudRepository;

public interface ICityRepository extends ICrudRepository<City, Long> {
    Iterable<City> findByName(String name);
}
