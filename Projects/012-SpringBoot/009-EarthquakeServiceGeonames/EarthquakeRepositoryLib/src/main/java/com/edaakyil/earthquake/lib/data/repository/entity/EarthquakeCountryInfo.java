package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EarthquakeCountryInfo {
    public long id;
    public long regionInfoId;
    public String distance;
    public String languages;
    public String countryCode;
    public String countryName;
}
