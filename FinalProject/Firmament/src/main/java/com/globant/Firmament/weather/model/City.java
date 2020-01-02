package com.globant.Firmament.weather.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Column(name = "city_id")
    private @Id @GeneratedValue Long id;
    private String name;
    private String country;
    private Double latitude;
    private Double longitude;
    private int times_called;

    protected City() {}

    public City(String name, String country, Double latitude, Double longitude) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.times_called = 1;
    }
}
