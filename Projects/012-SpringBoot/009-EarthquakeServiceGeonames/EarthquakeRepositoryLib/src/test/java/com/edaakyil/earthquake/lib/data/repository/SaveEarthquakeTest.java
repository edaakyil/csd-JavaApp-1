package com.edaakyil.earthquake.lib.data.repository;

import com.edaakyil.earthquake.lib.data.repository.dao.IRegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.dao.RegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeSave;
import com.edaakyil.earthquake.lib.data.repository.entity.RegionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class SaveEarthquakeTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    public void givenValue_whenEarthquake_thenSaveRegionInfo_generated_id_true() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
    {
        var earthquake = new EarthquakeSave();
        earthquake.regionInfo = new RegionInfo();
        earthquake.regionInfo.east = -66.96;
        earthquake.regionInfo.west = -125;
        earthquake.regionInfo.north = 49.5;
        earthquake.regionInfo.south = 25;

        var method = RegionInfoRepository.class.getDeclaredMethod("saveRegionInfo", RegionInfo.class);

        // invoke metodunda, earthquake.regionInfo ile m_regionInfoRepository'nin save metodunu çağırılacak
        // invoke metodunda, m_regionInfoRepository referansıyla earthquake'in regionInfo'suyla çağır diyoruz
        var result = (long) method.invoke(m_regionInfoRepository, earthquake.regionInfo);

        assertEquals(1L, result);
    }
}
