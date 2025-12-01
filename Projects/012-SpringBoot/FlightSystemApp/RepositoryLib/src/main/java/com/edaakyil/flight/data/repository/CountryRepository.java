package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
@Slf4j
public class CountryRepository implements ICountryRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public CountryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(Country country)
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
    public void deleteAll(Iterable<? extends Country> countries)
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
    public Optional<Country> findById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Country> findAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Country> findAllById(Iterable<Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends Country> S save(S country)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends Country> Iterable<S> saveAll(Iterable<S> countries)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
