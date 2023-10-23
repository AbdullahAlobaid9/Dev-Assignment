# IoT Weather Monitoring Application

## Introduction
This is a simple IoT weather monitoring application developed using Java's Spring Boot framework. The application is
composed of a set of components(modules): Weather Data Generator, Ingestion Service, and Monitor App. Each component is responsible for doing its job in the IoT weather monitoring system.

## Project Structure
The project is organized as follows:

- `WeatherDataGenerator`: Generates unrealistic simulated weather data for 10 different locations.
- `IngestionService`: Ingests secured weather data into a Kafka topic for further processing.
- `MonitorApp`: Consumes weather data securely from Kafka and stores it in a PostgreSQL database.

## Components

### Weather Data Generator
- The Weather Data Generator is a Spring Boot application responsible for simulating weather data.
- It provides an endpoint to generate weather data for 10 different locations.
- The generated data includes location name, coordinates (latitude and longitude), time, and degree.

### Ingestion Service
- The Ingestion Service is a secured Spring Boot service that ingests weather data into a Kafka topic.
- It ensures data is securely published to the Kafka topic.

### Monitor App
- The Monitor App is responsible for consuming weather data from the Kafka topic.
- It stores the data in a PostgreSQL database and provides secured endpoints to access the data.

## Dependencies
- Spring Boot
- Spring for Apache Kafka
- Spring Security
- Spring Data JPA
- PostgreSQL Driver

## Done by: 
Abdullah F. Alobaid 

## 
- Special thanks to [Suhail Alkowaileet]
