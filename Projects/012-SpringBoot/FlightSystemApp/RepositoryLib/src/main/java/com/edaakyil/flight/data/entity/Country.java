package com.edaakyil.flight.data.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(exclude = "m_name")
public class Country {
    @Accessors(prefix = "m_")
    private long m_id;

    @Accessors(prefix = "m_")
    private String m_name;
}
