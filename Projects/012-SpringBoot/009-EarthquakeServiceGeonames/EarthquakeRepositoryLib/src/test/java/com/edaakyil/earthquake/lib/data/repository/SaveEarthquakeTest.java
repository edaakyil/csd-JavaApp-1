package com.edaakyil.earthquake.lib.data.repository;

import com.edaakyil.earthquake.lib.data.repository.dao.IRegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeSave;
import com.edaakyil.earthquake.lib.data.repository.entity.RegionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class SaveEarthquakeTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    public void test()
    {
        var earthquake = new EarthquakeSave();
        earthquake.regionInfo = new RegionInfo();

        earthquake.regionInfo.east = -66.96;
        earthquake.regionInfo.west = -125;
        earthquake.regionInfo.north = 49.5;
        earthquake.regionInfo.south = 25;

        m_regionInfoRepository.saveEarthquake(earthquake);
    }
}
