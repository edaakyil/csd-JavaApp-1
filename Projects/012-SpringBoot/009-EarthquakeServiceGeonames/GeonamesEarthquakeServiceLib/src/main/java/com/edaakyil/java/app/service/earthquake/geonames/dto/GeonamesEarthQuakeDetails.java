package com.edaakyil.java.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Dışarıya vereceğimiz ana dto budur.
 */
public class GeonamesEarthQuakeDetails {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String earthquakeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String dateTime;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double depth;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double latitude;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double longitude;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double magnitude;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String street;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String locality;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String postalCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String distance;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String languages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryName;
}
