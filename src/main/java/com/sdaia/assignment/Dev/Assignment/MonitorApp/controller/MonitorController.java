package com.sdaia.assignment.Dev.Assignment.MonitorApp.controller;

import com.sdaia.assignment.Dev.Assignment.MonitorApp.model.WeatherData;
import com.sdaia.assignment.Dev.Assignment.MonitorApp.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitorController {

    private final WeatherDataRepository weatherDataRepository;

    @Autowired
    public MonitorController(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    @KafkaListener(topics = "your-kafka-topic")
    public void consumeWeatherData(WeatherData weatherData) {
        // Store the received data in the database
        weatherDataRepository.save(weatherData);
    }

    @GetMapping("/latest-weather")
    public List<WeatherData> getLatestWeatherData() {
        // Implement a method to fetch the latest weather data from the database
        List<WeatherData> latestData = weatherDataRepository.findLatestWeatherDataForAllLocations();
        return latestData;
    }

    @GetMapping("/average-weather")
    public Double getAverageWeather(@RequestParam String locationName) {
        // Implement a method to calculate and return the average weather for the specified location
        Double averageDegree = weatherDataRepository.calculateAverageDegreeForLocation(locationName);
        return averageDegree;
    }
}
