package com.weatherapiwrapper.openweather;

import lombok.Getter;


import java.util.List;

@Getter
public class OpenWeatherResponse {
    private List<Weather> weather;
    private Main main;
    private String name;

    @Getter
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
    }
}