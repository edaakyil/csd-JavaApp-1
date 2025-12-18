package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EarthquakeSave {
    public RegionInfo regionInfo;
    public EarthquakeInfo earthquakeInfo;
    public EarthquakeCountryInfo earthquakeCountryInfo;
    public EarthquakeAddressInfo earthquakeAddressInfo;
}
