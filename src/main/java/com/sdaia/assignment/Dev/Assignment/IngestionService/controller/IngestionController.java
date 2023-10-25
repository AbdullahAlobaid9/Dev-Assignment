package com.sdaia.assignment.Dev.Assignment.IngestionService.controller;

import com.sdaia.assignment.Dev.Assignment.IngestionService.service.IngestionService;
import com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.model.WeatherData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/ingest-weather")
    public void ingestWeatherData(@RequestBody WeatherData weatherData) {
        ingestionService.publishToKafka(weatherData);
    }
}