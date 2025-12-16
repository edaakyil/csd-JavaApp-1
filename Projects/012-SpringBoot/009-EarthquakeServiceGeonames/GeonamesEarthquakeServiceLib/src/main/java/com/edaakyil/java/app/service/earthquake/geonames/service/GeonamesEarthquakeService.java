package com.edaakyil.java.app.service.earthquake.geonames.service;

import com.edaakyil.java.app.service.earthquake.geonames.dto.*;
import com.edaakyil.java.app.service.earthquake.geonames.mapper.IGeonamesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class GeonamesEarthquakeService {
    private final RestTemplate m_restTemplate;
    private final IGeonamesMapper m_mapper;
    private static final String ADDRESS_URL_FORMAT = "http://api.geonames.org/addressJSON?lat=%f&lng=%f&username=edaakyil";
    private static final String COUNTRY_CODE_URL_FORMAT = "http://api.geonames.org/countryCodeJSON?lat=%f&lng=%f&username=edaakyil";
    private static final String EARTHQUAKE_URL_FORMAT = "http://api.geonames.org/earthquakesJSON?north=%f&south=%f&east=%f&west=%f&username=edaakyil";

    public GeonamesEarthquakeService(RestTemplate restTemplate, IGeonamesMapper mapper)
    {
        m_restTemplate = restTemplate;
        m_mapper = mapper;
    }

    private GeonamesEarthQuakeInfo findEarthquakes(double north, double south, double east, double west)
    {
        var url = String.format(EARTHQUAKE_URL_FORMAT, north, south, east, west);

        log.info("GeonamesEarthquakeService.findEarthquakes -> Earthquake url: {}", url);

        return m_restTemplate.getForObject(url, GeonamesEarthQuakeInfo.class);
    }

    private GeonamesCountryCode findCountryCode(double latitude, double longitude)
    {
        var url = String.format(COUNTRY_CODE_URL_FORMAT, latitude, longitude);

        log.info("GeonamesEarthquakeService.findCountryCode -> Country Code url: {}", url);

        return m_restTemplate.getForObject(url, GeonamesCountryCode.class);
    }

    private GeonamesAddress findAddress(double latitude, double longitude)
    {
        var url = String.format(ADDRESS_URL_FORMAT, latitude, longitude);

        log.info("GeonamesEarthquakeService.findAddress -> Address url: {}", url);

        //return m_restTemplate.getForObject(url, GeonamesAddressInfo.class).address;
        return Objects.requireNonNull(m_restTemplate.getForObject(url, GeonamesAddressInfo.class)).address;
    }

    private void earthquakeDetailInfoCallback(GeonamesEarthQuake geonamesEarthQuake, List<GeonamesEarthQuakeDetail> details)
    {
        var address = findAddress(geonamesEarthQuake.lat, geonamesEarthQuake.lng);
        var countryCode = findCountryCode(geonamesEarthQuake.lat, geonamesEarthQuake.lng);

        details.add(m_mapper.toGeonamesEarthQuakeDetail(geonamesEarthQuake, address, countryCode));
    }

    private GeonamesEarthQuakeDetailInfo toGeonamesEarthQuakeDetailInfo(GeonamesEarthQuakeInfo geonamesEarthQuakeInfo)
    {
        var detailInfo = new GeonamesEarthQuakeDetailInfo();

        detailInfo.earthquakes = new ArrayList<>();

        geonamesEarthQuakeInfo.earthquakes.forEach(e -> earthquakeDetailInfoCallback(e, detailInfo.earthquakes));

        return detailInfo;
    }

    // Dışarıya vereceğimiz metot (bizim ana metodumuz bu olacak):
    public GeonamesEarthQuakeDetailInfo findEarthquakesDetails(double north, double south, double east, double west)
    {
        var earthquakeInfo = findEarthquakes(north, south, east, west);

        return toGeonamesEarthQuakeDetailInfo(earthquakeInfo);
    }
}
