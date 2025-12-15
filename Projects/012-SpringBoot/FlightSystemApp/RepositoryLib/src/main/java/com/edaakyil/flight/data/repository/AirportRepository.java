package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.Airport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Optional;

@Repository
@Lazy
@Slf4j
public class AirportRepository implements IAirportRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    // Cümleleri üretme:
    private static final String SAVE_SQL = "insert into airports (name, city_id, open_date) values (:name, :cityId, :openDate)";

    public AirportRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static void fillAirports(ArrayList<Airport> airports, ResultSet rs) throws SQLException
    {
        do {
            var id = rs.getLong(1);
            var name = rs.getString(2);
            var cityId = rs.getLong(3);
            var openDate = rs.getDate(4).toLocalDate();
            var registerDateTime = rs.getTimestamp(5).toLocalDateTime();

            airports.add(new Airport(id, name, cityId, openDate, registerDateTime));
        } while (rs.next());
    }

    @Override
    public long count()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(Airport airport)
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
    public void deleteAll(Iterable<? extends Airport> airports)
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
    public Optional<Airport> findById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Airport> findByCityId(long cityId)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Airport> findByNameContains(String text)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Airport> findAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Airport> findAllById(Iterable<Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends Airport> S save(S airport)
    {
        log.info("AirportRepository.save -> Airport: {}", airport.toString());

        var paramSource = new BeanPropertySqlParameterSource(airport);
        paramSource.registerSqlType("openTime", Types.DATE);
        paramSource.registerSqlType("registerDateTime", Types.TIMESTAMP);

        var keyHolder = new GeneratedKeyHolder();
        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource, keyHolder);

        airport.setId((long)keyHolder.getKeys().get("airport_id"));

        return airport;
    }

    @Override
    public <S extends Airport> Iterable<S> saveAll(Iterable<S> airports)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
