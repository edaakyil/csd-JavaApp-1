package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
@Slf4j
public class CityRepository implements ICityRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(City city)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll(Iterable<? extends City> cities)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean existsById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Optional<City> findById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<City> findAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<City> findAllById(Iterable<Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends City> S save(S city)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends City> Iterable<S> saveAll(Iterable<S> cities)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
