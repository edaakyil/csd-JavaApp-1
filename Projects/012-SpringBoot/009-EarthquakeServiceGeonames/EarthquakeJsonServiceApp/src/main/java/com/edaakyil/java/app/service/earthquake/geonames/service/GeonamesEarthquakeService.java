package com.edaakyil.java.app.service.earthquake.geonames.service;

import com.edaakyil.java.app.service.earthquake.geonames.dto.GeonamesEarthQuakeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GeonamesEarthquakeService {
    private static final String GEONAMES_URL_FORMAT = "http://api.geonames.org/earthquakesJSON?north=%f&south=%f&east=%f&west=%f&username=edaakyil";
    private final RestTemplate m_restTemplate; // konuşmak için yani GET veya POST yapabilmek için

    public GeonamesEarthquakeService(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }

    public GeonamesEarthQuakeInfo findEarthquakes(double north, double south, double east, double west)
    {
        var url = String.format(GEONAMES_URL_FORMAT, north, south, east, west);

        // Yukarıya GET iletişim ile url'i ve reflection ile hangi sınıfı istediğini veriyoruz
        return m_restTemplate.getForObject(url, GeonamesEarthQuakeInfo.class);
    }
}
