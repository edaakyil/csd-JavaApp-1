package com.edaakyil.flight.data.service.mapper;

import com.edaakyil.flight.data.entity.Country;
import com.edaakyil.flight.data.service.dto.CountrySaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CountryMapperImpl", componentModel = "spring")
public interface ICountryMapper {
    Country toCountry(CountrySaveDTO countrySaveDTO);

    CountrySaveDTO toCountrySaveDTO(Country country);
}
