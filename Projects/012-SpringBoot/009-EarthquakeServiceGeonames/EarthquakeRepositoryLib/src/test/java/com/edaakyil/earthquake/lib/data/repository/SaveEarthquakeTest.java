package com.edaakyil.earthquake.lib.data.repository;

import com.edaakyil.earthquake.lib.data.repository.dao.RegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeSave;
import com.edaakyil.earthquake.lib.data.repository.entity.RegionInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class SaveEarthquakeTest {
    private RegionInfoRepository m_regionInfoRepository;

    @Autowired
    private ApplicationContext m_applicationContext;

    @BeforeEach
    public void setUp()
    {
        m_regionInfoRepository = m_applicationContext.getBean(RegionInfoRepository.class);
    }

    @Test
    public void test() throws SQLException
    {
        var earthquake = new EarthquakeSave();
        earthquake.regionInfo = new RegionInfo();
        earthquake.regionInfo.east = -66.96;
        earthquake.regionInfo.west = -125;
        earthquake.regionInfo.north = 49.5;
        earthquake.regionInfo.south = 25;

        var result = m_regionInfoRepository.saveRegionInfo(earthquake.regionInfo);

        assertEquals(1L, result);
    }
}
