package com.edaakyil.flight.data.service.mapper;

import com.edaakyil.flight.data.entity.City;
import com.edaakyil.flight.data.service.dto.CityDTO;
import com.edaakyil.flight.data.service.dto.CitySaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CityMapperImpl", componentModel = "spring")
public interface ICityMapper {
    City toCity(CitySaveDTO citySaveDTO);

    CityDTO toCityDTO(City city);
}
