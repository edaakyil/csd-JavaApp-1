package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class EarthquakeAddressInfo {
    public long id;
    public long regionInfoId;
    public String street;
    public String locality;
    public String postalCode;
}
