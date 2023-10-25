package com.sdaia.assignment.Dev.Assignment.MonitorApp.controller;

import com.sdaia.assignment.Dev.Assignment.MonitorApp.model.WeatherData;
import com.sdaia.assignment.Dev.Assignment.MonitorApp.repository.WeatherDataRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class MonitorController {

    private final WeatherDataRepository weatherDataRepository;

    public MonitorController(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    @KafkaListener(topics = "your-kafka-topic")
    public void consumeWeatherData(WeatherData weatherData) {
        // Store the received data in the database
        weatherDataRepository.save(weatherData);
    }
}