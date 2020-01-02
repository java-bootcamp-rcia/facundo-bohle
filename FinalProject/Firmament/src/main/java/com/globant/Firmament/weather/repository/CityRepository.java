package com.globant.Firmament.weather.repository;


import com.globant.Firmament.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
    public City findByName(String name);
}
