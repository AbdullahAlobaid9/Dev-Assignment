package com.sdaia.assignment.Dev.Assignment.MonitorApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "degree")
    private double degree;

    // Constructors, getters, and setters
}