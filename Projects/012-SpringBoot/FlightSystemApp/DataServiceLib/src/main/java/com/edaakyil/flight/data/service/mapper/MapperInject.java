package com.edaakyil.flight.data.service.mapper;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MapperInject {
    @Accessors(prefix = "m_")
    private final ICityMapper m_cityMapper;

    @Accessors(prefix = "m_")
    private final ICountryMapper m_countryMapper;

    @Accessors(prefix = "m_")
    private final IAirportMapper m_airportMapper;

    @Accessors(prefix = "m_")
    private final IFlightMapper m_flightMapper;

    public MapperInject(ICityMapper cityMapper, ICountryMapper countryMapper,
                        IAirportMapper airportMapper, IFlightMapper flightMapper)
    {
        m_cityMapper = cityMapper;
        m_countryMapper = countryMapper;
        m_airportMapper = airportMapper;
        m_flightMapper = flightMapper;
    }
}
