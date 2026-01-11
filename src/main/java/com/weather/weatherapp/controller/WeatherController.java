package com.weather.weatherapp.controller;

import com.weather.weatherapp.service.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {

        JSONObject data = weatherService.getWeatherData(city);

        model.addAttribute("city", data.getString("name"));
        model.addAttribute("temp", data.getJSONObject("main").getDouble("temp"));
        model.addAttribute("humidity", data.getJSONObject("main").getInt("humidity"));
        model.addAttribute("description",
                data.getJSONArray("weather").getJSONObject(0).getString("description"));

        return "index";
    }
}
