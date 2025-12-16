package com.edaakyil.java.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CountryInfo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String distance;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String languages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryName;
}
