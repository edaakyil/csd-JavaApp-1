package com.edaakyil.java.app.service.earthquake.geonames.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
public class GeonamesEarthQuakeInfo {
    @Accessors(prefix = "m_")
    private List<GeonamesEarthQuake> m_earthquakes;
}
