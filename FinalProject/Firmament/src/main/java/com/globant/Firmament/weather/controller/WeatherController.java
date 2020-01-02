package com.globant.Firmament.weather.controller;

import com.globant.Firmament.weather.service.WeatherService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/rain")
    public String getRainProbability(@RequestParam(required=true) String city,
                                     @RequestParam String country) {
       return weatherService.getRainProbability(city,country);
    }

    @GetMapping("/forecast")
    public String getForecast(@RequestParam(required=true) String city,
                                    @RequestParam String country){

       return weatherService.getForecast(city,country);
    }
}
