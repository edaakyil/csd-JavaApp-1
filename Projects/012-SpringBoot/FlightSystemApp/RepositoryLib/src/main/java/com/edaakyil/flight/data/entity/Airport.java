package com.edaakyil.flight.data.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Airport {
    @Accessors(prefix = "m_")
    private long m_id;

    @Accessors(prefix = "m_")
    private String m_name;

    @Accessors(prefix = "m_")
    private long m_cityId;
}