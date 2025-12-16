package com.edaakyil.java.app.service.earthquake.geonames.mapper;

import com.edaakyil.java.app.service.earthquake.geonames.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "GeonamesMapperImpl", componentModel = "spring")
public interface IGeonamesMapper {
    @Mapping(source = "postalcode", target = "postalCode")
    AddressInfo toAddressInfo(GeonamesAddress geonamesAddress);

    CountryInfo toCountryInfo(GeonamesCountryCode geonamesCountryCode);

    @Mapping(source = "lat", target = "latitude")
    @Mapping(source = "lng", target = "longitude")
    @Mapping(source = "eqid", target = "earthquakeId")
    EarthquakeInfo toEarthquakeInfo(GeonamesEarthQuake geonamesEarthQuake);
}
