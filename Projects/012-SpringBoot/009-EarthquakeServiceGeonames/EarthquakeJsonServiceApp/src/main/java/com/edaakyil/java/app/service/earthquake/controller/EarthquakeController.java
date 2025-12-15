package com.edaakyil.java.app.service.earthquake.controller;

import com.edaakyil.java.app.service.earthquake.geonames.dto.GeonamesEarthQuakeInfo;
import com.edaakyil.java.app.service.earthquake.geonames.service.GeonamesEarthquakeService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/earthquakes")
@Scope("prototype")
public class EarthquakeController {
    private final GeonamesEarthquakeService m_earthquakeService;

    public EarthquakeController(GeonamesEarthquakeService earthquakeService)
    {
        m_earthquakeService = earthquakeService;
    }

    @GetMapping("/json")
    public GeonamesEarthQuakeInfo findEarthquakesJSON(@RequestParam double north, @RequestParam double south,
                                                 @RequestParam double east, @RequestParam double west)
    {
        return m_earthquakeService.findEarthquakes(north, south, east, west);
    }
}

//curl "http://localhost:6767/api/earthquakes/json?north=44.1&south=-9.9&east=-22.4&west=55.2"
