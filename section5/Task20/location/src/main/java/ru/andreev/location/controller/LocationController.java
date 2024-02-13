package ru.andreev.location.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.andreev.location.model.Location;
import ru.andreev.location.model.Weather;
import ru.andreev.location.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationRepository locationRepository;
    private final RestTemplate restTemplate;

    @Value("${weather.url}")
    private String weatherUrl;

    public LocationController(LocationRepository locationRepository, RestTemplate restTemplate) {
        this.locationRepository = locationRepository;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        locationRepository.save(location);
        return ResponseEntity.ok(location);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        return ResponseEntity.ok(location);
    }

    @GetMapping
    public ResponseEntity<Weather> getWeather(@RequestParam String name) {
        Location location = locationRepository.findByName(name).
                orElseThrow(() -> new RuntimeException("Location not found"));

        String url = "http://" + weatherUrl + "/weather?lat=" +
                location.getLatitude() + "&lon=" + location.getLongitude();

        Weather weather = restTemplate.getForObject(url, Weather.class);

        return new ResponseEntity<>(weather, HttpStatus.OK);
    }
}