package com.edaakyil.earthquake.lib.service.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryInfo {
    public String distance;
    public String languages;
    public String countryCode;
    public String countryName;
}
