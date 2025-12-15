package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.constant.TestConstant;
import com.edaakyil.flight.data.entity.Airport;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPS_FILE)
@Slf4j
public class AirportRepositorySaveTest {
    @Autowired
    private IAirportRepository m_airportRepository;

    @Test
    public void test()
    {
        var airport = new Airport(0, "Sabiha Gökçen Airport", 315, LocalDate.now(), LocalDateTime.now());
        var expectedId = 1001L;

        m_airportRepository.save(airport);

        assertEquals(expectedId, airport.getId());
    }
}
