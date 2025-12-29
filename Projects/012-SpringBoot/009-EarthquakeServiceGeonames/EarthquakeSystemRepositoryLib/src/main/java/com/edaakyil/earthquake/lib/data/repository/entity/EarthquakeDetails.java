package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class EarthquakeDetails {
    public EarthquakeInfo earthquakeInfo;
    public EarthquakeCountryInfo earthquakeCountryInfo;
    public EarthquakeAddressInfo earthquakeAddressInfo;
}
