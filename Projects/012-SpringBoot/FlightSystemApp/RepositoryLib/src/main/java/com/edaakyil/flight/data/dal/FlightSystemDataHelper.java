package com.edaakyil.flight.data.dal;

import com.edaakyil.flight.data.entity.City;
import com.edaakyil.flight.data.entity.Country;
import com.edaakyil.flight.data.repository.IAirportRepository;
import com.edaakyil.flight.data.repository.ICityRepository;
import com.edaakyil.flight.data.repository.ICountryRepository;
import com.edaakyil.flight.data.repository.IFlightRepository;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
@Slf4j
public class FlightSystemDataHelper {
    private final ICityRepository m_cityRepository;
    private final IFlightRepository m_flightRepository;
    private final ICountryRepository m_countryRepository;
    private final IAirportRepository m_airportRepository;

    public FlightSystemDataHelper(ICityRepository cityRepository, IFlightRepository flightRepository,
                                  ICountryRepository countryRepository, IAirportRepository airportRepository)
    {
        m_cityRepository = cityRepository;
        m_flightRepository = flightRepository;
        m_countryRepository = countryRepository;
        m_airportRepository = airportRepository;
    }

    public void deleteCountryById(long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    public void deleteCityById(long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    public Optional<Country> findCountryById(long id)
    {
        try {
            log.info("FlightSystemDataHelper.findCountryById -> id: {}", id);

            return m_countryRepository.findById(id);

        } catch(Throwable ex) {
            log.error("FlightSystemDataHelper.findCountryById -> id: {}, Exception: {}, Message: {}",
                    id, ex.getClass().getSimpleName(), ex.getMessage());

            throw new RepositoryException("FlightSystemDataHelper.findCountryById", ex);
        }
    }

    public Optional<City> findCityById(long id)
    {
        try {
            log.info("FlightSystemDataHelper.findCityById -> id: {}", id);

            return m_cityRepository.findById(id);

        } catch(Throwable ex) {
            log.error("FlightSystemDataHelper.findCityById -> id: {}, Exception: {}, Message: {}",
                    id, ex.getClass().getSimpleName(), ex.getMessage());

            throw new RepositoryException("FlightSystemDataHelper.findCityById", ex);
        }
    }

    public Iterable<Country> findCountryByName(String name)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    public Iterable<City> findCityByName(String name)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    public Iterable<Country> findAllCountries()
    {
        try {
            log.info("FlightSystemDataHelper.findAllCountries");

            return m_countryRepository.findAll();

        } catch (Throwable ex) {
            log.error("FlightSystemDataHelper.findAllCountries -> Exception: {}, Message: {}",
                    ex.getClass().getSimpleName(), ex.getMessage());

            throw new RepositoryException("FlightSystemDataHelper.findAllCountries", ex);
        }
    }

    public Iterable<City> findAllCities()
    {
        try {
            log.info("FlightSystemDataHelper.findAllCities");

            return m_cityRepository.findAll();

        } catch (Throwable ex) {
            log.error("FlightSystemDataHelper.findAllCities -> Exception: {}, Message: {}",
                    ex.getClass().getSimpleName(), ex.getMessage());

            throw new RepositoryException("FlightSystemDataHelper.findAllCities", ex);
        }
    }

    public Country saveCountry(Country country)
    {
        try {
            log.info("FlightSystemDataHelper.saveCountry -> Country: {}", country.toString());

            return m_countryRepository.save(country);

        } catch (Throwable ex) {
            log.error("FlightSystemDataHelper.saveCountry -> Country: {}, Exception: {}, Message: {}",
                    country.toString(), ex.getClass().getSimpleName(), ex.getMessage());

            throw new RepositoryException("FlightSystemDataHelper.saveCountry", ex);
        }
    }

    public City saveCity(City city)
    {
        try {
            log.info("FlightSystemDataHelper.saveCity -> City: {}", city.toString());

            return m_cityRepository.save(city);

        } catch (Throwable ex) {
            log.error("FlightSystemDataHelper.saveCity -> City: {}, Exception: {}, Message: {}",
                    city.toString(), ex.getClass().getSimpleName(), ex.getMessage());

            throw new RepositoryException("FlightSystemDataHelper.saveCity", ex);
        }
    }

    public Country updateCountry(Country country)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    public City updateCity(City city)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
