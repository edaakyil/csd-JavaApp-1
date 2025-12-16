package com.edaakyil.java.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AddressInfo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String street;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String locality;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String postalCode;
}
