package com.edaakyil.java.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EarthquakeInfo {
    public String earthquakeId;
    public String dateTime;
    public double depth;
    public double latitude;
    public double longitude;
    public double magnitude;
}
