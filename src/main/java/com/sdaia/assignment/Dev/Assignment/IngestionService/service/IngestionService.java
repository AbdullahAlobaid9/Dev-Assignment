package com.sdaia.assignment.Dev.Assignment.IngestionService.service;

import com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.model.WeatherData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IngestionService {

    private final KafkaTemplate<String, WeatherData> kafkaTemplate;

    public IngestionService(KafkaTemplate<String, WeatherData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishToKafka(WeatherData weatherData) {
        String topic = "dev-assignment";

        kafkaTemplate.send(topic, weatherData);
    }
}
