package com.weatherapiwrapper.weather;

import org.springframework.web.bind.annotation.RequestBody;

public record WeatherRequest(
        String latitude,
        String longitude
) {
}
