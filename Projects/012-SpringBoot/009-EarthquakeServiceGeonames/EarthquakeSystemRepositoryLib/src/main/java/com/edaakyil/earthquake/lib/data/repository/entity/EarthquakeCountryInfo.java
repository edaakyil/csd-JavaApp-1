package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public class EarthquakeCountryInfo {
    public long id;
    public long regionInfoId;
    public String distance;
    public String languages;
    public String countryCode;
    public String countryName;
}
