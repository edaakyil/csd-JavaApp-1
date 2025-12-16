package com.edaakyil.java.app.service.earthquake.controller;

import com.edaakyil.java.app.service.earthquake.geonames.dto.GeonamesEarthQuakeInfoDetails;
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
    public GeonamesEarthQuakeInfoDetails findEarthquakesJSON(@RequestParam double north, @RequestParam double south,
                                                             @RequestParam double east, @RequestParam double west)
    {
        return m_earthquakeService.findEarthquakesDetails(north, south, east, west);
    }
}

// curl "http://localhost:6767/api/earthquakes/json?north=42.14&south=35.82&east=44.79&west=26.04"
// curl "http://localhost:6767/api/earthquakes/json?north=22&south=8.62&east=38.41&west=21.94"
// curl "http://localhost:6767/api/earthquakes/json?north=49.04&south=46.43&east=16.98&west=9.48"
