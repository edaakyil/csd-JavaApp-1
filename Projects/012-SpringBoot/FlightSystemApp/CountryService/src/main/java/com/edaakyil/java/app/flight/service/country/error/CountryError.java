package com.edaakyil.java.app.flight.service.country.error;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CountryError {
    @Accessors(prefix = "m_")
    private String m_countryName;

    @Accessors(prefix = "m_")
    private String m_errorMessage;

    @Accessors(prefix = "m_")
    private int m_statusCode;
}
