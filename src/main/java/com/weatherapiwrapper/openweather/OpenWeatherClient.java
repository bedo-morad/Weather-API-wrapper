package com.weatherapiwrapper.openweather;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "open-OpenWeatherResponse",
        url = "https://api.openweathermap.org/data/2.5"
)
public interface OpenWeatherClient {

    @GetMapping("/weather?lat={latitude}&lon={longitude}&appid={apiKey}")
    Optional<OpenWeatherResponse> getCurrentWeather(
            @PathVariable String apiKey,
            @PathVariable String latitude,
            @PathVariable String longitude
    );
}