package com.edaakyil.flight.data.service;

import com.edaakyil.flight.data.dal.FlightSystemDataHelper;
import com.edaakyil.flight.data.service.dto.CityDTO;
import com.edaakyil.flight.data.service.dto.CitySaveDTO;
import com.edaakyil.flight.data.service.dto.CountryDTO;
import com.edaakyil.flight.data.service.dto.CountrySaveDTO;
import com.edaakyil.flight.data.service.mapper.MapperInject;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import com.edaakyil.java.lib.data.service.exception.DataServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class FlightSystemDataService {
    private final FlightSystemDataHelper m_flightSystemDataHelper;
    private final MapperInject m_mapperInject;

    public FlightSystemDataService(FlightSystemDataHelper flightSystemDataHelper, MapperInject mapperInject)
    {
        m_flightSystemDataHelper = flightSystemDataHelper;
        m_mapperInject = mapperInject;
    }

    public void deleteCountryById(long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public void deleteCityById(long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Optional<CountryDTO> findCountryById(long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    // Bize City gelecek biz de bunu CityDTO'a dönüştürüceğiz.
    public Optional<CityDTO> findCityById(long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Optional<CountryDTO> findCountryByName(String name)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Optional<CityDTO> findCityByName(String name)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Iterable<CountryDTO> findAllCountries()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    // Bize Iterable<City> gelecek ve biz de bunu Iterable<CityDTO>'ya dönüştürüceğiz.
    public Iterable<CityDTO> findAllCities()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public CountrySaveDTO saveCountry(CountrySaveDTO countrySaveDTO)
    {
        try {
            log.info("FlightSystemDataService.saveCountry -> Country: {}", countrySaveDTO.toString());

            m_flightSystemDataHelper.saveCountry(m_mapperInject.getCountryMapper().toCountry(countrySaveDTO));

            return countrySaveDTO;

        } catch (RepositoryException ex) {
            log.error("FlightSystemDataService.saveCountry -> Country: {}, RepositoryException: {}, Message: {}",
                    countrySaveDTO, ex.getClass().getSimpleName(), ex.getMessage());

            throw new DataServiceException("FlightSystemDataService.saveCountry -> RepositoryException", ex);
        } catch (Throwable ex) {
            log.error("FlightSystemDataService.saveCountry -> Country: {}, Exception: {}, Message: {}",
                    countrySaveDTO.toString(), ex.getClass().getSimpleName(), ex.getMessage());

            throw new DataServiceException("FlightSystemDataService.saveCountry -> Any Exception", ex);
        }
    }

    // Aynı data'ya geri dönüyoruz
    public CitySaveDTO saveCity(CitySaveDTO citySaveDTO)
    {
        try {
            log.info("FlightSystemDataService.saveCity -> City: {}", citySaveDTO.toString());

            m_flightSystemDataHelper.saveCity(m_mapperInject.getCityMapper().toCity(citySaveDTO));

            return citySaveDTO;

        } catch (RepositoryException ex) {
            log.error("FlightSystemDataService.saveCity -> City: {}, RepositoryException: {}, Message: {}",
                    citySaveDTO, ex.getClass().getSimpleName(), ex.getMessage());

            throw new DataServiceException("FlightSystemDataService.saveCity -> RepositoryException", ex);
        } catch (Throwable ex) {
            log.error("FlightSystemDataService.saveCity -> City: {}, Exception: {}, Message: {}",
                    citySaveDTO.toString(), ex.getClass().getSimpleName(), ex.getMessage());

            throw new DataServiceException("FlightSystemDataService.saveCity -> Any Exception", ex);
        }
    }
}
