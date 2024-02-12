package com.example.weather.controller;


import com.example.weather.model.Weather;
import com.example.weather.model.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Value("${openweathermap.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<Weather> getWeather(@RequestParam float lat, @RequestParam float lon) throws JsonProcessingException {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        ResponseEntity<String> weatherJson = restTemplate.getForEntity(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        WeatherData weatherData = objectMapper.readValue(weatherJson.getBody(), WeatherData.class);

        return new ResponseEntity<>(weatherData.getWeather(), HttpStatus.OK);
    }
}
