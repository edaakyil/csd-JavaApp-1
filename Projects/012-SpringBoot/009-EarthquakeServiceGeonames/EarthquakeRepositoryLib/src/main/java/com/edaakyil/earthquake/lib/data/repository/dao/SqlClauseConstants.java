package com.edaakyil.earthquake.lib.data.repository.dao;

final class SqlClauseConstants {
    private SqlClauseConstants()
    {
    }

    static final String FIND_DETAILS_BY_REGION_INFO_SQL = """
            select
            ei.earthquake_id, ei.latitude, ei.longitude, ei."depth", ei.date_time, ei.magnitude,
            eci."language", eci.distance, eci.country_code, eci.country_name,
            eai.locality, eai.postal_code, eai.street
            from region_info ri
            inner join earthquake_info ei on ei.region_info_id = ri.region_info_id
            inner join earthquake_country_info eci on eci.region_info_id = ri.region_info_id
            inner join earthquake_address_info eai on eai.region_info_id = ri.region_info_id
            where abs(east - :east) < 0.00001 and abs(west - :west) < 0.00001 and abs(south - :south) < 0.00001 and abs(north - :north) < 0.00001;
            """;

    static final String SAVE_REGION_INFO_SQL = "insert into region_info (east, west, north, south) values (:east, :west, :north, :south)";

    static final String SAVE_EARTHQUAKE_INFO_SQL = """
            insert into earthquake_info
            (region_info_id, date_time, depth, latitude, longitude, earthquake_id, magnitude)
            values
            (:region_info_id, :date_time, :depth, :latitude, :longitude, :earthquake_id, :magnitude)
            """;

    static final String SAVE_EARTHQUAKE_QUERY_INFO_SQL = "insert into earthquake_query_info (region_info_id) values (:region_info_id)";

    static final String SAVE_EARTHQUAKE_COUNTRY_INFO_SQL = """
            insert into earthquake_country_info
            (region_info_id, distance, language, country_code, country_name)
            values
            (:region_info_id, :distance, :language, :country_code, :country_name)
            """;

    static final String SAVE_EARTHQUAKE_ADDRESS_INFO_SQL = """
            insert into earthquake_address_info
            (region_info_id, locality, street, postal_code)
            values
            (:region_info_id, :locality, :street, :postal_code)
            """;
}
