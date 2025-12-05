package com.edaakyil.flight.data;

import com.edaakyil.flight.data.repository.ICityRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Disabled
public class CityRepositoryFindByIdTest {
    @Autowired
    private ICityRepository m_cityRepository;

    @Test
    public void givenValue_whenId_thenFound()
    {
        var name = "Milotice";
        var id = 6L;

        assertEquals(name, m_cityRepository.findById(id).get().getName());
    }

    @Test
    public void givenValue_whenId_thenOptionalNotEmpty()
    {
        var id = 6L;

        assertTrue(m_cityRepository.findById(id).isPresent());
    }

    @Test
    public void givenValue_whenId_thenOptionalEmpty()
    {
        var id = 3000L;

        assertTrue(m_cityRepository.findById(id).isEmpty());
    }
}
