package com.edaakyil.flight.data.service.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CitySaveDTO {
    @Accessors(prefix = "m_")
    private String m_name;

    @Accessors(prefix = "m_")
    private long m_countryId;
}
