package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
@Lazy
@Slf4j
public class CountryRepository implements ICountryRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    // Cümleleri üretme:
    private static final String DELETE_BY_ID_SQL = "call sp_delete_country_by_id(:id)";
    private static final String FIND_ALL_SQL = "select * from find_all_countries()";
    private static final String FIND_BY_ID_SQL = "select * from find_country_by_id(:id)";
    private static final String FIND_BY_NAME_SQL = "select * from find_country_by_name(:name)";
    private static final String SAVE_SQL = "select * from insert_country(:name)";

    public CountryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private void fillCountries(ArrayList<Country> countries, ResultSet rs) throws SQLException
    {
        do
            // tablonun alan isimlerinin kullanılmasının avantajıları daha algılanabilir olmasıdır ve alanların bildirim sırasının bilinmesinin gerek olmamasıdır.
            // index kullanmanın bir avantajı hızlı işlem yapmaktır.
            countries.add(new Country(rs.getLong(1), rs.getString(2))); // index kullanmanın bir avantajı hızlı işlem yapmaktır.
            //countries.add(new Country(rs.getLong("country_id"), rs.getString("name"))); // daha yavaş.
        while (rs.next());
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
        log.info("CountryRepository.deleteByID -> country_id: {}", id);

        var paramMap = new HashMap<String, Object>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.update(DELETE_BY_ID_SQL, paramMap);
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
        log.info("CountryRepository.findById -> country_id: {}", id);

        var countries = new ArrayList<Country>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_BY_ID_SQL, paramMap, (ResultSet rs) -> fillCountries(countries, rs));

        return countries.isEmpty() ? Optional.empty() : Optional.of(countries.get(0));
    }

    @Override
    public Iterable<Country> findByName(String name)
    {
        log.info("CountryRepository.findByName -> name: {}", name);

        var countries = new ArrayList<Country>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("name", name);

        m_namedParameterJdbcTemplate.query(FIND_BY_NAME_SQL, paramMap, rs -> { fillCountries(countries, rs); });

        return countries;
    }

    @Override
    public Iterable<Country> findAll()
    {
        log.info("CountryRepository.findAll");

        var countries = new ArrayList<Country>();

        m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, rs -> { fillCountries(countries, rs); });

        return countries;
    }

    @Override
    public Iterable<Country> findAllById(Iterable<Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends Country> S save(S country)
    {
        log.info("CountryRepository.save -> city: {}", country.toString());

        var paramMap = new HashMap<String, Object>();
        paramMap.put("name", country.getName());

        m_namedParameterJdbcTemplate.query(SAVE_SQL, paramMap, (ResultSet rs) -> country.setId(rs.getLong(1)));

        return country;
    }

    @Override
    public <S extends Country> Iterable<S> saveAll(Iterable<S> countries)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
