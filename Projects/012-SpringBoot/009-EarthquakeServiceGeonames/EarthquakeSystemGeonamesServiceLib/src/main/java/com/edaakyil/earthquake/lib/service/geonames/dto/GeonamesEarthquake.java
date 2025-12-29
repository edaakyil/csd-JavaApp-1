package com.edaakyil.earthquake.lib.service.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeonamesEarthquake {
    public String eqid;
    @JsonProperty("datetime")
    public String dateTime;
    public double depth;
    public double lat;
    public double lng;
    public double magnitude;
}
