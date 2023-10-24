package com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.controller;


import com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.model.Coordinates;
import com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.model.WeatherData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherGeneratorController {

    @GetMapping("/generate-weather")
    public List<WeatherData> generateWeatherData() {
        List<WeatherData> weatherDataList = new ArrayList<>();

        // Simulate weather data generation for 10 different locations
        for (int i = 1; i <= 10; i++) {
            WeatherData weatherData = new WeatherData();
            weatherData.setId((long) i);
            weatherData.setLocationName("Location " + i);

            Coordinates coordinates = new Coordinates();
            coordinates.setLatitude(generateRandomLatitude());
            coordinates.setLongitude(generateRandomLongitude());
            weatherData.setCoordinates(coordinates);

            weatherData.setTime(LocalDateTime.now().toString());
            weatherData.setDegree(generateRandomDegree());

            weatherDataList.add(weatherData);
        }

        return weatherDataList;
    }

    private double generateRandomLatitude() {
        // Implement logic to generate random latitude
        return Math.random() * (90 - (-90)) + (-90);
    }

    private double generateRandomLongitude() {
        // Implement logic to generate random longitude
        return Math.random() * (180 - (-180)) + (-180);
    }

    private double generateRandomDegree() {
        // Implement logic to generate random degree
        return Math.random() * (100 - (-100)) + (-100);
    }
}