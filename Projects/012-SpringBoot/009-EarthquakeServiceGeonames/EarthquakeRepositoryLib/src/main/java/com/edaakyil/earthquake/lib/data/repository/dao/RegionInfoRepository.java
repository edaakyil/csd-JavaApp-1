package com.edaakyil.earthquake.lib.data.repository.dao;

import com.edaakyil.earthquake.lib.data.repository.entity.*;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Slf4j
@Repository
public class RegionInfoRepository implements IRegionInfoRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private static final String FIND_DETAILS_BY_REGION_INFO_SQL = SqlClauseConstants.FIND_DETAILS_BY_REGION_INFO_SQL;
    private static final String SAVE_REGION_INFO_SQL = SqlClauseConstants.SAVE_REGION_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_QUERY_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_QUERY_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_COUNTRY_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_COUNTRY_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_ADDRESS_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_ADDRESS_INFO_SQL;

    public RegionInfoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // id'yi dönüyor
    private long saveRegionInfo(RegionInfo regionInfo) throws SQLException
    {
        log.info("RegionInfoRepository.saveRegionInfo -> RegionInfo: {}", regionInfo.toString());

        var paramSource = new BeanPropertySqlParameterSource(regionInfo);
        var keyHolder = new GeneratedKeyHolder();

        // NamedParameterJdbcTemplate sınıfının update metodu kaç tane data'nın update edildiği bilgisini veren
        // int türden bir değere geri dönüyor.
        if (m_namedParameterJdbcTemplate.update(SAVE_REGION_INFO_SQL, paramSource, keyHolder) != 1)
            throw new SQLException();

        return (long) keyHolder.getKeyList().get(0).get("region_info_id");
    }

    private void saveEarthquakeInfo(EarthquakeInfo earthquakeInfo)
    {

    }

    private void setEarthquakeCountryInfo(EarthquakeCountryInfo earthquakeCountryInfo)
    {

    }

    private void saveEarthquakeAddressInfo(EarthquakeAddressInfo earthquakeAddressInfo)
    {

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
    public void saveEarthquake(EarthquakeSave earthquakeSave)
    {
        try {
            long regionInfoId = saveRegionInfo(earthquakeSave.regionInfo);
            saveEarthquakeInfo(earthquakeSave.earthquakeInfo);
            setEarthquakeCountryInfo(earthquakeSave.earthquakeCountryInfo);
            saveEarthquakeAddressInfo(earthquakeSave.earthquakeAddressInfo);

            log.info("Generated regionInfoId: {}", regionInfoId);

        } catch (SQLException ex) {
            log.error("RegionInfoRepository.saveEarthquake -> RepositoryException Message: {}", ex.getMessage());

            throw new RepositoryException("RegionInfoRepository.saveEarthquake -> RepositoryException", ex);
        }
    }

    @Override
    public Iterable<EarthquakeDetails> findByRegionInfo(double east, double west, double north, double south)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}
