package com.edaakyil.java.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dışarıya vereceğimiz ana dto budur.
 */
public class GeonamesEarthQuakeDetails {
    @JsonProperty("earthquakeInfo")
    public EarthquakeInfo earthquake;

    @JsonProperty("addressInfo")
    public AddressInfo address;

    @JsonProperty("countryInfo")
    public CountryInfo country;
}
