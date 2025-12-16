package com.edaakyil.java.app.service.earthquake.geonames.mapper;

import com.edaakyil.java.app.service.earthquake.geonames.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "GeonamesMapperImpl", componentModel = "spring")
public interface IGeonamesMapper {
    @Mapping(source = "geonamesEarthQuake.lat", target = "latitude")
    @Mapping(source = "geonamesEarthQuake.lng", target = "longitude")
    @Mapping(source = "geonamesEarthQuake.eqid", target = "earthquakeId")
    @Mapping(source = "geonamesAddress.postalcode", target = "postalCode")
    @Mapping(source = "geonamesCountryCode.distance", target = "distance")
    @Mapping(source = "geonamesCountryCode.countryCode", target = "countryCode")
    GeonamesEarthQuakeDetails toGeonamesEarthQuakeDetails(
            GeonamesEarthQuake geonamesEarthQuake, GeonamesAddress geonamesAddress, GeonamesCountryCode geonamesCountryCode
    );
}
