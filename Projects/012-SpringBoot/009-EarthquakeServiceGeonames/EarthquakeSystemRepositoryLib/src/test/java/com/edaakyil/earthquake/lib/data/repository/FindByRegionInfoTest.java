package com.edaakyil.earthquake.lib.data.repository;

import com.edaakyil.earthquake.lib.data.repository.dao.IRegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FindByRegionInfoTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    @Order(0)
    public void givenValue_whenLocation_thenFound()
    {
        var earthquake = new EarthquakeSave();

        earthquake.regionInfo = RegionInfo.builder()
                .east(-66.96)
                .west(-125)
                .north(49.5)
                .south(25)
                .build();

        earthquake.earthquakeInfo = EarthquakeInfo.builder()
                .earthquakeId("Test Earthquake")
                .dateTime("2023-02-06 04:00:00")
                .depth(100)
                .latitude(45.67)
                .longitude(40.67)
                .magnitude(7.6)
                .build();

        earthquake.earthquakeCountryInfo = EarthquakeCountryInfo.builder()
                .countryCode("AT")
                .countryName("Austria")
                .languages("de-AT,hr,hu,sl")
                .distance("0")
                .build();

        earthquake.earthquakeAddressInfo = EarthquakeAddressInfo.builder()
                .locality("Amsterdam")
                .postalCode("1071 CX")
                .street("Paulus Potterstraat")
                .build();

        m_regionInfoRepository.saveEarthquake(earthquake);

        var earthquakeDetails = m_regionInfoRepository.findByRegionInfo(-66.96, -125, 49.5, 25);

        //assertTrue(StreamSupport.stream(earthquakeDetails.spliterator(), false).count() > 0);
        assertTrue(StreamSupport.stream(earthquakeDetails.spliterator(), false).findAny().isPresent());
    }

    @Test
    @Order(1)
    public void givenValue_whenLocation_thenNotFound()
    {
        var earthquake = new EarthquakeSave();

        earthquake.regionInfo = RegionInfo.builder()
                .east(-66.96)
                .west(-125)
                .north(49.5)
                .south(25)
                .build();

        earthquake.earthquakeInfo = EarthquakeInfo.builder()
                .earthquakeId("Test Earthquake")
                .dateTime("2023-02-06 04:00:00")
                .depth(100)
                .latitude(45.67)
                .longitude(40.67)
                .magnitude(7.6)
                .build();

        earthquake.earthquakeCountryInfo = EarthquakeCountryInfo.builder()
                .countryCode("AT")
                .countryName("Austria")
                .languages("de-AT,hr,hu,sl")
                .distance("0")
                .build();

        earthquake.earthquakeAddressInfo = EarthquakeAddressInfo.builder()
                .locality("Amsterdam")
                .postalCode("1071 CX")
                .street("Paulus Potterstraat")
                .build();

        m_regionInfoRepository.saveEarthquake(earthquake);

        var earthquakeDetails = m_regionInfoRepository.findByRegionInfo(-66.96, -125, 49.5, 29.4);

        assertTrue(StreamSupport.stream(earthquakeDetails.spliterator(), false).findAny().isEmpty());
    }
}
