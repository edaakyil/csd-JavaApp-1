package com.edaakyil.earthquake.lib.data.repository.dal;

import com.edaakyil.earthquake.lib.data.repository.dao.IRegionInfoRepository;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeDetails;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeSave;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RepositoryLibDataHelper {
    private final IRegionInfoRepository m_regionInfoRepository;

    public RepositoryLibDataHelper(IRegionInfoRepository regionInfoRepository)
    {
        m_regionInfoRepository = regionInfoRepository;
    }

    public void saveEarthquake(EarthquakeSave earthquakeSave)
    {
        log.info("EarthquakeSystemDataHelper.saveEarthquake");

        m_regionInfoRepository.saveEarthquake(earthquakeSave);
    }

    public List<EarthquakeDetails> findEarthquakesByRegionInfo(double east, double west, double north, double south)
    {
        try {
            log.info("EarthquakeSystemDataHelper.findEarthquakesByRegionInfo");

           return m_regionInfoRepository.findByRegionInfo(east, west, north, south);

        } catch (Throwable ex) {
            log.error("EarthquakeSystemDataHelper.findEarthquakesByRegionInfo -> Message: {}", ex.getMessage());

            throw new RepositoryException("EarthquakeSystemDataHelper.findEarthquakesByRegionInfo", ex);
        }
    }

    public void saveEarthquakeQueryInfo(long regionInfoId)
    {
        try {
            log.info("EarthquakeSystemDataHelper.saveEarthquakeQueryInfo");

            m_regionInfoRepository.saveEarthquakeQueryInfo(regionInfoId);

        } catch (Throwable ex) {
            log.error("EarthquakeSystemDataHelper.saveEarthquakeQueryInfo -> Message: {}", ex.getMessage());

            throw new RepositoryException("EarthquakeSystemDataHelper.saveEarthquakeQueryInfo", ex);
        }
    }
}
