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

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SaveEarthquakeTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    @Order(0)
    public void givenValue_whenEarthquake_thenSaveRegionInfo_generated_id_true() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
    {
        var earthquake = new EarthquakeSave();
        earthquake.regionInfo = new RegionInfo();
        earthquake.regionInfo.east = -66.96;
        earthquake.regionInfo.west = -125;
        earthquake.regionInfo.north = 49.5;
        earthquake.regionInfo.south = 25;

        var method = m_regionInfoRepository.getClass().getDeclaredMethod("saveRegionInfo", RegionInfo.class);

        // invoke metodunda, earthquake.regionInfo ile m_regionInfoRepository'nin save metodunu çağırılacak
        // invoke metodunda, m_regionInfoRepository referansıyla earthquake'in regionInfo'suyla çağır diyoruz
        var result = (long) method.invoke(m_regionInfoRepository, earthquake.regionInfo);

        assertEquals(1, result);
    }

    @Test
    @Order(1)
    public void givenValue_whenEarthquake_thenSaveNotThrowsSQLException()
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
        earthquake.earthquakeCountryInfo.countryCode = "AT";
        earthquake.earthquakeCountryInfo.countryName = "Austria";
        earthquake.earthquakeCountryInfo.languages = "de-AT,hr,hu,sl";
        earthquake.earthquakeCountryInfo.distance = "0";

        earthquake.earthquakeAddressInfo = new EarthquakeAddressInfo();
        earthquake.earthquakeAddressInfo.locality = "Amsterdam";
        earthquake.earthquakeAddressInfo.postalCode = "1071 CX";
        earthquake.earthquakeAddressInfo.street = "Paulus Potterstraat";

        // assertDoesNotThrow -> hiçbir şey fırlatmayacak anlamına gelir
        assertDoesNotThrow(() -> m_regionInfoRepository.saveEarthquake(earthquake));
    }
}
