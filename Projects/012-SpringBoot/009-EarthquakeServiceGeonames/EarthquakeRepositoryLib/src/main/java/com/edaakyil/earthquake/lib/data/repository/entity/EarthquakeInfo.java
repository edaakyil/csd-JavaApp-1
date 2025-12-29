package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
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
