package com.edaakyil.flight.data.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"m_name", "m_countryId"})
public class City {
    @Accessors(prefix = "m_")
    private long m_id;

    @Accessors(prefix = "m_")
    private String m_name;

    @Accessors(prefix = "m_")
    private long m_countryId;
}
