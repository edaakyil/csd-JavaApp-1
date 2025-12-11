package com.edaakyil.java.app.flight.service.city.controller;

import com.edaakyil.flight.data.service.FlightSystemDataService;
import com.edaakyil.flight.data.service.dto.CitySaveDTO;
import com.edaakyil.flight.data.service.dto.CityUpdateDTO;
import com.edaakyil.java.app.flight.service.city.error.CityError;
import com.edaakyil.java.lib.data.service.exception.DataServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system/flight/city")
@ComponentScan(basePackages = "com.edaakyil")
@Slf4j
public class CityController {
    private final FlightSystemDataService m_flightSystemDataService;

    public CityController(FlightSystemDataService flightSystemDataService)
    {
        m_flightSystemDataService = flightSystemDataService;
    }

    @PostMapping("add")
    public ResponseEntity<Object> addCity(@RequestBody CitySaveDTO citySaveDTO)
    {
        try {
            log.info("CityController.addCity -> City: {}", citySaveDTO.toString());

            return ResponseEntity.ok(m_flightSystemDataService.saveCity(citySaveDTO));

        } catch (DataServiceException ex) {
            var cityError = new CityError(citySaveDTO.getName(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value());

            log.error("CityController.addCity -> City: {}, Exception: {}, Response: {}", citySaveDTO.toString(),
                    ex.getMessage(), cityError.toString());

            return ResponseEntity.internalServerError().body(cityError);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCityById(@PathVariable("id") long id)
    {
        log.info("CityController.deleteCityById -> Id: {}", id);

        throw new  UnsupportedOperationException("'CityController.deleteCityById' not implemented yet!...");
    }

    @GetMapping("find")
    public ResponseEntity<Object> findCityByName(@RequestParam String name)
    {
        log.info("CityController.findCityByName -> Name: {}", name);

        throw new  UnsupportedOperationException("'CityController.findCityByName' not implemented yet!...");
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Object> findCityById(@PathVariable("id") long id)
    {
        log.info("CityController.findCityById -> Id: {}", id);

        throw new  UnsupportedOperationException("'CityController.findCityById' not implemented yet!...");
    }

    @GetMapping("find/all")
    public ResponseEntity<Object> findAllCities()
    {
        log.info("CityController.findAllCities");

        throw new  UnsupportedOperationException("'CityController.findAllCities' not implemented yet!...");
    }

    @PutMapping("update")
    public ResponseEntity<Object> updateCity(@RequestBody CityUpdateDTO cityUpdateDTO)
    {
        log.info("CityController.updateCity -> City: {}", cityUpdateDTO.toString());

        throw new  UnsupportedOperationException("'CityController.updateCity' not implemented yet!...");
    }
}
