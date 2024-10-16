package com.weatherapiwrapper.weather;

import com.weatherapiwrapper.openweather.OpenWeatherResponse;
import com.weatherapiwrapper.openweather.OpenWeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    //application-dev.properties -> apiKey
    @Value("${apiKey}")
    private String apiKey;
    private final OpenWeatherClient openWeatherClient;

    @Cacheable("WeatherCache")
    public WeatherResponse getCurrentWeather(WeatherRequest weatherRequest) {
        Optional<OpenWeatherResponse> response = openWeatherClient.getCurrentWeather(apiKey, weatherRequest.latitude(), weatherRequest.longitude());
        if (response.isPresent()) {
            OpenWeatherResponse openWeatherResponse = response.get();
            return new WeatherResponse(
                    openWeatherResponse.getName(),
                    openWeatherResponse.getWeather().get(0).getMain(),
                    openWeatherResponse.getWeather().get(0).getDescription(),
                    openWeatherResponse.getMain().getTemp(),
                    openWeatherResponse.getMain().getFeels_like(),
                    openWeatherResponse.getMain().getTemp_min(),
                    openWeatherResponse.getMain().getTemp_max(),
                    openWeatherResponse.getMain().getPressure(),
                    openWeatherResponse.getMain().getHumidity()
            );
        } else {
            // Handle the case where the response is not present
            return null;
        }
    }
}
