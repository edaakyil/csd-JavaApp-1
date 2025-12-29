package com.edaakyil.earthquake.lib.data.repository;

import com.edaakyil.earthquake.lib.data.repository.dao.IRegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.*;
import org.junit.jupiter.api.*;
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

        earthquake.regionInfo = RegionInfo.builder()
                .east(-66.96)
                .west(-125)
                .north(49.5)
                .south(25)
                .build();

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

        // assertDoesNotThrow -> hiçbir şey fırlatmayacak anlamına gelir
        assertDoesNotThrow(() -> m_regionInfoRepository.saveEarthquake(earthquake));
    }
}
