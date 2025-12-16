package com.edaakyil.java.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeonamesEarthQuake {
    public String eqid;
    @JsonProperty("datetime")
    public String dateTime;
    public double depth;
    public double lat;
    public double lng;
    public double magnitude;
}
