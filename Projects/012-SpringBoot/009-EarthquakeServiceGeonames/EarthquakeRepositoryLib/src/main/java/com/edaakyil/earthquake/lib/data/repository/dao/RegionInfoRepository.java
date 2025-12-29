package com.edaakyil.earthquake.lib.data.repository.dao;

import com.edaakyil.earthquake.lib.data.repository.entity.*;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class RegionInfoRepository implements IRegionInfoRepository {
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String FIND_DETAILS_BY_REGION_INFO_SQL = SqlClauseConstants.FIND_DETAILS_BY_REGION_INFO_SQL;
    private static final String SAVE_REGION_INFO_SQL = SqlClauseConstants.SAVE_REGION_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_QUERY_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_QUERY_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_COUNTRY_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_COUNTRY_INFO_SQL;
    private static final String SAVE_EARTHQUAKE_ADDRESS_INFO_SQL = SqlClauseConstants.SAVE_EARTHQUAKE_ADDRESS_INFO_SQL;

    public  RegionInfoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private EarthquakeInfo createEarthquakeInfo(String eqId, String dateTime, double lat, double lng, double depth, double magnitude)
    {
        return EarthquakeInfo.builder()
                .earthquakeId(eqId)
                .dateTime(dateTime)
                .latitude(lat)
                .longitude(lng)
                .depth(depth)
                .magnitude(magnitude)
                .build();
    }

    private EarthquakeCountryInfo createEarthquakeCountryInfo(String languages, String distance, String countryCode, String countryName)
    {
        return EarthquakeCountryInfo.builder()
                .countryCode(countryCode)
                .countryName(countryName)
                .distance(distance)
                .languages(languages)
                .build();
    }

    private EarthquakeAddressInfo createEarthquakeAddressInfo(String locality, String postalCode, String street)
    {
        return EarthquakeAddressInfo.builder()
                .street(street)
                .locality(locality)
                .postalCode(postalCode)
                .build();
    }

    private EarthquakeDetails createEarthquakeDetails(EarthquakeInfo quake, EarthquakeCountryInfo country, EarthquakeAddressInfo address)
    {
        return EarthquakeDetails.builder()
                .earthquakeInfo(quake)
                .earthquakeCountryInfo(country)
                .earthquakeAddressInfo(address)
                .build();
    }

    private void fillEarthquakeDetails(ResultSet rs, List<EarthquakeDetails> list) throws SQLException
    {
        do {
            var quake = createEarthquakeInfo(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
            var country = createEarthquakeCountryInfo(rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            var address = createEarthquakeAddressInfo(rs.getString(11), rs.getString(12), rs.getString(13));

            list.add(createEarthquakeDetails(quake, country, address));
        } while (rs.next());
    }

    // id'yi dönüyor
    public long saveRegionInfo(RegionInfo regionInfo) throws SQLException
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
        var paramMap = new HashMap<String, Object>();
        paramMap.put("region_info_id", earthquakeInfo.regionInfoId);
        paramMap.put("depth", earthquakeInfo.depth);
        paramMap.put("latitude", earthquakeInfo.latitude);
        paramMap.put("longitude", earthquakeInfo.longitude);
        paramMap.put("earthquake_id", earthquakeInfo.earthquakeId);
        paramMap.put("magnitude", earthquakeInfo.magnitude);
        paramMap.put("date_time", LocalDateTime.parse(earthquakeInfo.dateTime, FORMATTER));
        //paramMap.put("date_time", LocalDateTime.parse(earthquakeInfo.dateTime, DateTimeFormatter.ISO_DATE_TIME));

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_INFO_SQL, paramMap);
    }

    private void saveEarthquakeCountryInfo(EarthquakeCountryInfo earthquakeCountryInfo)
    {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("region_info_id", earthquakeCountryInfo.regionInfoId);
        paramMap.put("distance", earthquakeCountryInfo.distance);
        paramMap.put("languages", earthquakeCountryInfo.languages);
        paramMap.put("country_code", earthquakeCountryInfo.countryCode);
        paramMap.put("country_name", earthquakeCountryInfo.countryName);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_COUNTRY_INFO_SQL, paramMap);
    }

    private void saveEarthquakeAddressInfo(EarthquakeAddressInfo earthquakeAddressInfo)
    {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("region_info_id", earthquakeAddressInfo.regionInfoId);
        paramMap.put("locality", earthquakeAddressInfo.locality);
        paramMap.put("street", earthquakeAddressInfo.street);
        paramMap.put("postal_code", earthquakeAddressInfo.postalCode);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_ADDRESS_INFO_SQL, paramMap);
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
    public Optional<RegionInfo> findById(Long id)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<EarthquakeDetails> findByRegionInfo(double east, double west, double north, double south)
    {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("east", east);
        paramMap.put("west", west);
        paramMap.put("north", north);
        paramMap.put("south", south);

        var earthquakes = new ArrayList<EarthquakeDetails>();
        m_namedParameterJdbcTemplate.query(FIND_DETAILS_BY_REGION_INFO_SQL, paramMap, (ResultSet rs) -> fillEarthquakeDetails(rs, earthquakes));

        return earthquakes;
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
            var regionInfoId = saveRegionInfo(earthquakeSave.regionInfo);

            log.info("Generated RegionInfo id: {}", regionInfoId);

            earthquakeSave.earthquakeInfo.regionInfoId = regionInfoId;
            earthquakeSave.earthquakeAddressInfo.regionInfoId = regionInfoId;
            earthquakeSave.earthquakeCountryInfo.regionInfoId = regionInfoId;

            saveEarthquakeInfo(earthquakeSave.earthquakeInfo);
            saveEarthquakeCountryInfo(earthquakeSave.earthquakeCountryInfo);
            saveEarthquakeAddressInfo(earthquakeSave.earthquakeAddressInfo);
            saveEarthquakeQueryInfo(regionInfoId);

        } catch (SQLException ex) {
            log.error("RegionInfoRepository.saveEarthquake -> RepositoryException Message: {}", ex.getMessage());

            throw new RepositoryException("RegionInfoRepository.saveEarthquake -> RepositoryException", ex);
        }
    }

    @Override
    public void saveEarthquakeQueryInfo(long regionInfoId)
    {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("region_info_id", regionInfoId);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_QUERY_INFO_SQL, paramMap);
    }
}
