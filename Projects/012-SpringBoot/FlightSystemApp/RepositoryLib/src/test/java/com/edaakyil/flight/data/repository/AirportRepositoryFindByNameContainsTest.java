package com.edaakyil.flight.data.repository;

import com.edaakyil.flight.data.constant.TestConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPS_FILE)
@Slf4j
public class AirportRepositoryFindByNameContainsTest {
    @Autowired
    private IAirportRepository m_airportRepository;

    @Test
    public void test()
    {
        var text = "Green";
        var expectedCount = 4L;
        var count = StreamSupport.stream(m_airportRepository.findByNameContains(text).spliterator(), false).count();

        assertEquals(expectedCount, count);
    }
}
