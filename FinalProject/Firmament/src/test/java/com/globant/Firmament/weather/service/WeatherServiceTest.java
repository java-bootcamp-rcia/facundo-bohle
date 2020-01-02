package com.globant.Firmament.weather.service;

import com.globant.Firmament.weather.model.City;
import com.globant.Firmament.weather.repository.CityRepository;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.aspectj.util.LangUtil.isEmpty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {
    private WeatherService weatherService;

    @Mock
    CityRepository cityRepository;

    @Before
    public void setUp(){
        weatherService= new WeatherService(cityRepository);
    }

    @Test
    public void givenCorrectData_whenGet_thenRetrieveRainProbability() {

        String probability  = weatherService.getRainProbability("Corrientes","Argentina");
        System.out.println(probability);

        assertFalse(isEmpty(probability));

    }

    @Test
    public void givenCorrectData_whenGet_thenRetrieve5DayForecast(){
        String forecast = weatherService.getForecast("London","United Kingdom");
        System.out.println(forecast)
        ;
    }

    @Test
    public void canRetrieveMostRequestedCity() {

        Object mostRequested = weatherService.mostRequested();

        assertNotNull(mostRequested);

    }

    @Test
    public void canRetrieveLeastRequestedCity() {
        Object leastRequested = weatherService.leastRequested();

        assertNotNull(leastRequested);
    }

}
