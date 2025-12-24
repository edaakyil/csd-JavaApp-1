package com.edaakyil.earthquake.lib.data.repository;

import com.edaakyil.earthquake.lib.data.repository.dao.IRegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class SaveEarthquakeQueryInfoTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    public void givenValue_whenRegionInfoId_thenSaveEarthquakeQueryInfo()
    {
        var earthquake = new EarthquakeSave();
        earthquake.regionInfo = new RegionInfo();
        earthquake.regionInfo.east = -66.96;
        earthquake.regionInfo.west = -125;
        earthquake.regionInfo.north = 49.5;
        earthquake.regionInfo.south = 25;

        earthquake.earthquakeInfo = new EarthquakeInfo();
        earthquake.earthquakeInfo.earthquakeId = "Test Earthquake";
        earthquake.earthquakeInfo.dateTime = "2023-02-06 04:00:00";
        earthquake.earthquakeInfo.depth = 100;
        earthquake.earthquakeInfo.latitude = 45.67;
        earthquake.earthquakeInfo.longitude = 40.67;
        earthquake.earthquakeInfo.magnitude = 7.6;

        earthquake.earthquakeCountryInfo = new EarthquakeCountryInfo();
        earthquake.earthquakeAddressInfo = new EarthquakeAddressInfo();

        m_regionInfoRepository.saveEarthquake(earthquake);

        assertDoesNotThrow(() -> m_regionInfoRepository.saveEarthquakeQueryInfo(1));
    }
}
