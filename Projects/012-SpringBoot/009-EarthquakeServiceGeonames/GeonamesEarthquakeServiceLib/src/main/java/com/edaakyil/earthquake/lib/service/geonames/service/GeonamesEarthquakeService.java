package com.edaakyil.earthquake.lib.service.geonames.service;

import com.edaakyil.earthquake.lib.service.geonames.dto.*;
import com.edaakyil.earthquake.lib.service.geonames.mapper.IGeonamesMapper;
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

    private GeonamesEarthQuakeDetails toGeonamesEarthQuakeDetails(
            GeonamesEarthQuake geonamesEarthQuake, GeonamesAddress geonamesAddress, GeonamesCountryCode geonamesCountryCode
    )
    {
        var details = new GeonamesEarthQuakeDetails();
        details.address = m_mapper.toAddressInfo(geonamesAddress);
        details.country = m_mapper.toCountryInfo(geonamesCountryCode);
        details.earthquake = m_mapper.toEarthquakeInfo(geonamesEarthQuake);

        return details;
    }

    private void earthquakeDetailsInfoCallback(GeonamesEarthQuake geonamesEarthQuake, List<GeonamesEarthQuakeDetails> details)
    {
        var address = findAddress(geonamesEarthQuake.lat, geonamesEarthQuake.lng);
        var countryCode = findCountryCode(geonamesEarthQuake.lat, geonamesEarthQuake.lng);

        details.add(toGeonamesEarthQuakeDetails(geonamesEarthQuake, address, countryCode));
    }

    private GeonamesEarthQuakeDetailsInfo toGeonamesEarthQuakeDetailsInfo(GeonamesEarthQuakeInfo geonamesEarthQuakeInfo)
    {
        var detailsInfo = new GeonamesEarthQuakeDetailsInfo();
        detailsInfo.earthquakes = new ArrayList<>();

        geonamesEarthQuakeInfo.earthquakes.forEach(e -> earthquakeDetailsInfoCallback(e, detailsInfo.earthquakes));

        return detailsInfo;
    }

    // Dışarıya vereceğimiz metot (bizim ana metodumuz bu olacak):
    public GeonamesEarthQuakeDetailsInfo findEarthquakesDetailsInfo(double north, double south, double east, double west)
    {
        var earthquakeInfo = findEarthquakes(north, south, east, west);

        return toGeonamesEarthQuakeDetailsInfo(earthquakeInfo);
    }
}
