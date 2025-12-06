package com.edaakyil.flight.data;

import com.edaakyil.flight.data.constant.TestConstant;
import com.edaakyil.flight.data.entity.City;
import com.edaakyil.flight.data.repository.ICityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPS_FILE)
public class CityRepositorySaveTest {
    @Autowired
    private ICityRepository m_cityRepository;

    /*
    @Test
    public void givenValue_whenCity_thenSaveAndFindById()
    {
        var city = new City(0, "Zonguldak", 309);
        var expectedId = 1001L;

        m_cityRepository.save(city);

        var cityOpt = m_cityRepository.findById(expectedId);
        assertEquals(expectedId, cityOpt.get().getId());
    }
    */

    @Test
    public void givenValue_whenCity_thenSetIdentity()
    {
        var city = new City(0, "Zonguldak", 309);
        var expectedId = 1001L;

        m_cityRepository.save(city);

        assertEquals(expectedId, city.getId());
    }
}
