package com.edaakyil.java.app.service.earthquake.geonames.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
public class GeonamesEarthQuake {
    private String m_equid;
    private String m_dateTime;
    private double m_depth;
    private double m_lat;
    private double m_lng;
    private double m_magnitude;
}
