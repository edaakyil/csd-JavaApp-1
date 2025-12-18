package com.edaakyil.earthquake.lib.data.repository.dao;

import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeDetails;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeSave;
import com.edaakyil.earthquake.lib.data.repository.entity.RegionInfo;
import com.edaakyil.java.lib.data.repository.ICrudRepository;

public interface IRegionInfoRepository extends ICrudRepository<RegionInfo, Long> {
    boolean saveRegionInfo(EarthquakeSave earthquakeSave);
    Iterable<EarthquakeDetails> findByRegionInfo(double east, double west, double north, double south);
}
