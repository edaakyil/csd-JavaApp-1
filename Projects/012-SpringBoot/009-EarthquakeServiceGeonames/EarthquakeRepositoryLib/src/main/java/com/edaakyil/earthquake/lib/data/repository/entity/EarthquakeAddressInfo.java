package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EarthquakeAddressInfo {
    public long id;
    public long regionInfoId;
    public String street;
    public String locality;
    public String postalCode;
}
