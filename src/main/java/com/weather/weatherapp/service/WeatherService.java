package com.weather.weatherapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class WeatherService {

    private final String API_KEY = "a37af0a5bf3494080a534a3bbaaefe0f";

    public JSONObject getWeatherData(String city) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=" + API_KEY + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return new JSONObject(response);
    }
}
