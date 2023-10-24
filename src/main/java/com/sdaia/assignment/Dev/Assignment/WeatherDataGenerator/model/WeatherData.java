package com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.model;

public class WeatherData {
    private Long id;
    private String locationName;
    private Coordinates coordinates;
    private String time;
    private double degree;

    public WeatherData() {
        // Default constructor
    }

    public WeatherData(Long id, String locationName, Coordinates coordinates, String time, double degree) {
        this.id = id;
        this.locationName = locationName;
        this.coordinates = coordinates;
        this.time = time;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}