package com.edaakyil.earthquake.lib.data.repository.dao;

import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeDetails;
import com.edaakyil.earthquake.lib.data.repository.entity.EarthquakeSave;
import com.edaakyil.earthquake.lib.data.repository.entity.RegionInfo;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class RegionInfoRepository implements IRegionInfoRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private static final String FIND_DETAILS_BY_REGION_INFO_SQL = SqlClauseConstants.FIND_DETAILS_BY_REGION_INFO_SQL;
    private static final String SAVE_REGION_INFO_SQL = SqlClauseConstants.SAVE_REGION_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_COUNTRY_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_COUNTRY_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_ADDRESS_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_ADDRESS_INFO_SQL;

    public RegionInfoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(RegionInfo regionInfo)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll(Iterable<? extends RegionInfo> regionInfos)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean existsById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Optional<RegionInfo> findById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<RegionInfo> findAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<RegionInfo> findAllById(Iterable<Long> ids)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends RegionInfo> S save(S regionInfo)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends RegionInfo> Iterable<S> saveAll(Iterable<S> regionInfos)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    @Transactional
    public boolean saveRegionInfo(EarthquakeSave earthquakeSave)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<EarthquakeDetails> findByRegionInfo(double east, double west, double north, double south)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
