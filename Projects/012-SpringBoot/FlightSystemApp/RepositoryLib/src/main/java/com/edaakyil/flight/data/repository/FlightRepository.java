package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.Flight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
@Slf4j
public class FlightRepository implements IFlightRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public FlightRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(Flight flight)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteById(String id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll(Iterable<? extends Flight> flights)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean existsById(String id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Optional<Flight> findById(String id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Flight> findAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Flight> findAllById(Iterable<String> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends Flight> S save(S flight)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends Flight> Iterable<S> saveAll(Iterable<S> flights)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
