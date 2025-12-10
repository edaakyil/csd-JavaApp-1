create table if not exists countries (
	country_id bigserial primary key,
	name varchar(250)
);

create table if not exists cities (
	city_id bigserial primary key,
	name varchar(250) not null,
	country_id bigint references countries(country_id) not null
);

create table if not exists airports (
	airport_id bigserial primary key,
	name varchar(250) not null,
	city_id bigint references cities(city_id) not null
);

create table if not exists flights (
	flight_id varchar(20) primary key,
	departure_airport_id bigint references airports(airport_id) not null,
	destination_airport_id bigint references airports(airport_id) not null,
	departure_date_time timestamp not null,
	return_date_time timestamp not null,
	price real not null
);

truncate table flights restart identity cascade;
truncate table airports restart identity cascade;
truncate table cities restart identity cascade;
truncate table countries restart identity cascade;

DROP PROCEDURE IF EXISTS sp_delete_country_by_id;

CREATE OR REPLACE PROCEDURE sp_delete_country_by_id(bigint)
LANGUAGE plpgsql
AS
'
    BEGIN
        DELETE FROM countries WHERE country_id = $1;
    END
';

DROP PROCEDURE IF EXISTS sp_delete_city_by_id;

CREATE OR REPLACE PROCEDURE sp_delete_city_by_id(bigint)
LANGUAGE plpgsql
AS
'
    BEGIN
        DELETE FROM cities WHERE city_id = $1;
    END
';

DROP FUNCTION IF EXISTS find_country_by_id;

CREATE OR REPLACE FUNCTION find_country_by_id(bigint)
RETURNS TABLE (id bigint, country_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM countries WHERE country_id = $1;
        RETURN QUERY SELECT * FROM countries WHERE country_id = $1;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS find_city_by_id;

CREATE OR REPLACE FUNCTION find_city_by_id(bigint)
RETURNS TABLE (id bigint, city_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM cities WHERE city_id = $1;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS find_country_by_name;

CREATE OR REPLACE FUNCTION find_country_by_name(varchar(250))
RETURNS TABLE (id bigint, country_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM countries WHERE name = $1;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS find_city_by_name;

CREATE OR REPLACE FUNCTION find_city_by_name(varchar(250))
RETURNS TABLE (id bigint, city_name varchar(250), country_id bigint) -- table-valued function'a geri dönüyoruz
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM cities WHERE name = $1;
    END
' LANGUAGE plpgsql;  -- fonksiyonlarda language tag'ını buraya ekliyoruz

DROP FUNCTION IF EXISTS find_all_countries;

CREATE OR REPLACE FUNCTION find_all_countries()
RETURNS TABLE (id bigint, country_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM countries;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS find_all_cities;

CREATE OR REPLACE FUNCTION find_all_cities()
RETURNS TABLE (id bigint, city_name varchar(250), country_id bigint)
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM cities;
    END
' LANGUAGE plpgsql;