package com.weatherapiwrapper.weather;

public record WeatherResponse(
        String cityName,
        String weather,
        String description,
        double temp,
        double feels_like,
        double temp_min,
        double temp_max,
        int pressure,
        int humidity
        ) {
}
