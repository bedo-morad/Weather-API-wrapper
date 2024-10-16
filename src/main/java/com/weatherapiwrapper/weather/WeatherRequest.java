package com.weatherapiwrapper.weather;


public record WeatherRequest(
        String latitude,
        String longitude
) {
}
