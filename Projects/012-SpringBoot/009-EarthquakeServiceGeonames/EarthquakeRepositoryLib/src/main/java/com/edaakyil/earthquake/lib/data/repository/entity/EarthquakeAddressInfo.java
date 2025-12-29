package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public class EarthquakeAddressInfo {
    public long id;
    public long regionInfoId;
    public String street;
    public String locality;
    public String postalCode;
}
