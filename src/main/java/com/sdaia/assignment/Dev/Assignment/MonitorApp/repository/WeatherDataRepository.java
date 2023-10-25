package com.sdaia.assignment.Dev.Assignment.MonitorApp.repository;

import com.sdaia.assignment.Dev.Assignment.MonitorApp.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}