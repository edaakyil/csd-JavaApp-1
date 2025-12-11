package com.edaakyil.java.app.flight.service.country.controller;

import com.edaakyil.flight.data.service.FlightSystemDataService;
import com.edaakyil.flight.data.service.dto.CountrySaveDTO;
import com.edaakyil.java.app.flight.service.country.error.CountryError;
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
@RequestMapping("/api/system/flight/country")
@ComponentScan(basePackages = "com.edaakyil")
@Slf4j
public class CountryController {
    private final FlightSystemDataService m_flightSystemDataService;

    public CountryController(FlightSystemDataService flightSystemDataService)
    {
        m_flightSystemDataService = flightSystemDataService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCountry(@RequestBody CountrySaveDTO countrySaveDTO)
    {
        try {
            log.info("CountryController.addCountry -> Country: {}", countrySaveDTO.toString());

            return ResponseEntity.ok(m_flightSystemDataService.saveCountry(countrySaveDTO));

        } catch (DataServiceException ex) {
            var countryError = new CountryError(countrySaveDTO.getName(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value());

            log.error("CountryController.addCountry -> Country: {}, Exception: {}, Response: {}", countrySaveDTO.toString(),
                    ex.getMessage(), countryError.toString());

            return ResponseEntity.internalServerError().body(countryError);
        }
    }
}
