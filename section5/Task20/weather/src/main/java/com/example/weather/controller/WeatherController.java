package com.example.weather.controller;


import com.example.weather.model.Weather;
import com.example.weather.model.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
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
    private final RestTemplate restTemplate;

    @Value("${openweathermap.apiKey}")
    private String apiKey;

    @Value("${external.weather.url}")
    private String externalWeatherUrl;


    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @Cacheable(value = "weatherCache", key = "#lat + '-' + #lon")
    public ResponseEntity<Weather> getWeather(@RequestParam float lat, @RequestParam float lon) throws JsonProcessingException {
        String url = externalWeatherUrl + "?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        ResponseEntity<String> weatherJson = restTemplate.getForEntity(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        WeatherData weatherData = objectMapper.readValue(weatherJson.getBody(), WeatherData.class);

        return new ResponseEntity<>(weatherData.getWeather(), HttpStatus.OK);
    }
}
