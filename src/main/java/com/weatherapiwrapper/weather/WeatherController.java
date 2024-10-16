package com.weatherapiwrapper.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService service;

    @GetMapping("/current")
    public ResponseEntity<WeatherResponse> getCurrentWeather(
            @RequestBody WeatherRequest weatherRequest
    ) {
        return ResponseEntity.ok(service.getCurrentWeather(weatherRequest));
    }
}
