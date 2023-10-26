package com.sdaia.assignment.Dev.Assignment.MonitorApp.repository;

import com.sdaia.assignment.Dev.Assignment.MonitorApp.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    @Query("SELECT wd FROM WeatherData wd WHERE wd.id IN (SELECT MAX(w.id) FROM WeatherData w GROUP BY w.locationName)")
    List<WeatherData> findLatestWeatherDataForAllLocations();

    @Query("SELECT AVG(wd.degree) FROM WeatherData wd WHERE wd.locationName = :locationName")
    Double calculateAverageDegreeForLocation(@Param("locationName") String locationName);
}
