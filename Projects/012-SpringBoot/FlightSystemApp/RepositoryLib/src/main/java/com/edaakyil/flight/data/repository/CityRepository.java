package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
public class CityRepository implements ICityRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate; // Bunu biz yaratmıyoruz. Bu, arkaplanda yaratılıyor.
    // Cümleleri üretme:
    private static final String FIND_ALL_SQL = "SELECT * FROM cities";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM cities WHERE city_id = :id";
    private static final String FIND_BY_NAME_SQL = "SELECT * FROM cities WHERE name = :name";
    private static final String SAVE_SQL = "INSERT INTO cities (name, country_id) VALUES (:name, :countryId)";

    public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private void fillCities(ArrayList<City> cities, ResultSet rs) throws SQLException
    {
        // ResultSet'i dolaşma:
        do {
            // Buradan data'ları alırız:

            // JDBC'nin tasarımında index numaraları 1'den başlar 0'dan değil. Bu yüzden getLong() metodunun argümanını 1'den başlattık
            // getLong() metoduna argüman olarak index verdiğimizde bu index tabloyu oluştururkenki alanların bildirim sırasına karşılık gelir
            cities.add(new City(rs.getLong(1), rs.getString(2), rs.getLong(3)));
            // getLong() metodunun "city_id" argümanı veritabanındaki kolunun birebir aynı ismidir
            //cities.add(new City(rs.getLong("city_id"), rs.getString("name"), rs.getLong("country_id")));  // daha yavaş

        } while (rs.next());
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
        var cities = new ArrayList<City>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_BY_ID_SQL, paramMap, rs -> { fillCities(cities, rs); });
        //m_namedParameterJdbcTemplate.query(FIND_BY_ID_SQL, paramMap, (ResultSet rs) -> fillCities(cities, rs)); // it is also OK

        // Artık id'ye ilişkin veri varsa gelecek olan data'nın bir tane olduğuna eminiz
        return cities.isEmpty() ? Optional.empty() : Optional.of(cities.get(0));
    }

    @Override
    public Iterable<City> findByName(String name)
    {
        var cities = new ArrayList<City>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("name", name);

        m_namedParameterJdbcTemplate.query(FIND_BY_NAME_SQL, paramMap, rs -> { fillCities(cities, rs); });

        return cities;
    }

    @Override
    public Iterable<City> findAll()
    {
        var cities = new ArrayList<City>();

        // cities'in içini doldurma:
        //m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, rs -> fillCities(cities, rs)); // Ambiguity error
        m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, (ResultSet rs) -> fillCities(cities, rs));
        //m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, rs -> { fillCities(cities, rs); });  // it is also OK

        return cities;
    }

    @Override
    public Iterable<City> findAllById(Iterable<Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends City> S save(S city)
    {
        var parameterSource = new BeanPropertySqlParameterSource(city);

        m_namedParameterJdbcTemplate.update(SAVE_SQL, parameterSource);

        return city;
    }

    @Override
    public <S extends City> Iterable<S> saveAll(Iterable<S> cities)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
