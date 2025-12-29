package com.edaakyil.earthquake.lib.service.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dışarıya vereceğimiz ana dto budur.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeonamesEarthQuakeDetails {
    @JsonProperty("earthquakeInfo")
    public EarthquakeInfo earthquake;

    @JsonProperty("addressInfo")
    public AddressInfo address;

    @JsonProperty("countryInfo")
    public CountryInfo country;
}
