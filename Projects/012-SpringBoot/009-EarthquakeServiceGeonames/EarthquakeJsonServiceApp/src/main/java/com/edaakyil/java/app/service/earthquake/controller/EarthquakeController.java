package com.edaakyil.java.app.service.earthquake.controller;

import com.edaakyil.java.app.service.earthquake.geonames.dto.GeonamesEarthQuakeDetailInfo;
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
    public GeonamesEarthQuakeDetailInfo findEarthquakesJSON(@RequestParam double north, @RequestParam double south,
                                                             @RequestParam double east, @RequestParam double west)
    {
        return m_earthquakeService.findEarthquakesDetails(north, south, east, west);
    }
}

// curl "http://localhost:6767/api/earthquakes/json?north=42.14&south=35.82&east=44.79&west=26.04"  --> Türkiye
// curl "http://localhost:6767/api/earthquakes/json?north=22.0&south=8.62&east=38.41&west=21.94"  --> Eritrea
// curl "http://localhost:6767/api/earthquakes/json?north=49.04&south=46.43&east=16.98&west=9.48"  --> Austria
// curl "http://localhost:6767/api/earthquakes/json?north=53.51&south=50.75&east=7.23&west=3.36"  --> Hollanda
// curl "http://localhost:6767/api/earthquakes/json?north=49.5&south=25&east=-66.96&west=-125"  --> US
