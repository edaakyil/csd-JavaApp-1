create database db_japp1_flight;

create table if not exists countries(
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
	-- cities tablosuyla airports tablosunda bir foreign key oluşturduk. 
	-- Buradaki city_id'im benim foreign key'im cities tablosundaki primary key'im ile eşleşti.
	-- Artık biz airports tablosunda o şehrin ismini ve ülke bilgisini tutmadan da city_id'den gidebiliriz.
	city_id bigint references cities(city_id) not null  -- foreign key oluşturduk
);

create table if not exists flights(
	flight_id varchar(20) primary key,
	departure_airport_id bigint references airports(airport_id) not null,
	destination_airport_id bigint references airports(airport_id) not null,
	departure_date_time timestamp not null,
	return_date_time timestamp not null,
	price real not null
);