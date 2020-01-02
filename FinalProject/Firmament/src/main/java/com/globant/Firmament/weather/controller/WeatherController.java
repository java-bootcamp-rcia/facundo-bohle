package com.globant.Firmament.weather.controller;

import com.globant.Firmament.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/mostRequested")
    public Object getMostRequested() {

        return weatherService.mostRequested();
    }

    @GetMapping("/leastRequested")
    public Object getLeastRequested() {

        return weatherService.leastRequested();
    }

}
