package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EarthquakeInfo {
    public long id;
    public long regionInfoId;
    public String earthquakeId;
    public String dateTime;
    public double depth;
    public double latitude;
    public double longitude;
    public double magnitude;
}
