package com.globant.Firmament.weather.repository;


import com.globant.Firmament.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CityRepository extends JpaRepository<City,Long> {
    City findByName(String name);

    @Query("SELECT name,times_called FROM City ORDER BY times_called DESC")
    Collection<Object> findAllMostRequested();

    @Query("SELECT name,times_called FROM City ORDER BY times_called ASC")
    Collection<Object> findAllLeastRequested();
}
