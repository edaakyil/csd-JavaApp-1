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