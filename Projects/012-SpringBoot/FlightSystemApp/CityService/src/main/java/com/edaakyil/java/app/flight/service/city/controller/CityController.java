package com.edaakyil.java.app.flight.service.city.controller;

import com.edaakyil.flight.data.service.FlightSystemDataService;
import com.edaakyil.flight.data.service.dto.CitySaveDTO;
import com.edaakyil.java.app.flight.service.city.error.CityError;
import com.edaakyil.java.lib.data.service.exception.DataServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
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
}
