package com.globant.Firmament.weather.service;

import com.globant.Firmament.weather.model.City;
import com.globant.Firmament.weather.repository.CityRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class WeatherService {

    @Autowired
    private CityRepository repository;

    private RestTemplate restTemplate;

    protected WeatherService() {}

    public WeatherService(CityRepository repository) {
        this.repository=repository;
    }


    public String getForecast(String city, String country) {
        JSONObject daily = getWeeklyForecast(city,country);
        JSONArray data = daily.getJSONArray("data");
        data.remove(7);
        data.remove(6);
        data.remove(5);

        Gson gson = new Gson();

        return gson.toJson(data);
    }

    public String getRainProbability(String city, String country) {

        JSONObject daily= getWeeklyForecast(city,country);
        JSONArray data = daily.getJSONArray("data");
        JSONObject today= data.getJSONObject(0);
        Double rainProbability = today.getDouble("precipProbability");
        rainProbability*=100;

        return Double.toString(rainProbability)+"%";
    }

    private JSONObject getWeeklyForecast(String city, String country) {
        ArrayList<String> coords = getCoordinates(city,country);
        String latitude=coords.get(0);
        String longitude = coords.get(1);
        String url=("https://api.darksky.net/forecast/8c5d46c30339b7c4d9d4e3cc8b5a1b51/"+latitude+","+longitude);

        ResponseEntity<String> response= restTemplate.getForEntity(url,String.class);

        JSONObject object= new JSONObject(response.getBody());
        JSONObject daily = object.getJSONObject("daily");
        return daily;
    }

    private ArrayList<String> getCoordinates(String city, String country) {

        String url="https://api.opencagedata.com/geocode/v1/json?q="+city+","+country+"&key=e819bcc3aace4265a8388f7ace5a0f89&language=en&pretty=1";

        ArrayList<String> coords= new ArrayList<>();

        restTemplate= new RestTemplate();

        ResponseEntity<String> response= restTemplate.getForEntity(url,String.class);

        JSONObject obj= new JSONObject(response.getBody());
        JSONArray results= obj.getJSONArray("results");
        JSONObject result= results.getJSONObject(0);
        JSONObject coordinates= result.getJSONObject("geometry");

        Double lat= coordinates.getDouble("lat");
        Double lng= coordinates.getDouble("lng");

        coords.add(Double.toString(lat));
        coords.add(Double.toString(lng));


        persistCity(city,country,lat,lng);

        return coords;
    }

    private void persistCity(String name, String country, Double latitude, Double longitude) {

        City city = repository.findByName(name);

        if (city==null) {
            City newCity = new City(name,country,latitude,longitude);
            repository.save(newCity);
            return;
        }

        System.out.println("Saving new city.... "+name);
        city.setTimes_called((city.getTimes_called()+1));
        repository.save(city);
        System.out.println(name+" Successfully saved.");

        return;
    }

    public Object mostRequested() {
        Collection<Object> sortedCities = repository.findAllMostRequested();
        return sortedCities.stream().findFirst().get();
    }

    public Object leastRequested() {
        Collection<Object> sortedCities = repository.findAllLeastRequested();
        return sortedCities.stream().findFirst().get();
    }
}
