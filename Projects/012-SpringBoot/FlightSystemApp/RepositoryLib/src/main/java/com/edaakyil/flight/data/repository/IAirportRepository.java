package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.Airport;
import com.edaakyil.java.lib.data.repository.ICrudRepository;

public interface IAirportRepository extends ICrudRepository<Airport, Long> {
    Iterable<Airport> findByCityId(long cityId);
    Iterable<Airport> findByNameContains(String text); // içerisinde bu isim geçen havalimanları
}
