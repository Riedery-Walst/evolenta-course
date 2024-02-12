package ru.andreev.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.andreev.person.model.User;
import ru.andreev.person.model.Weather;
import ru.andreev.person.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    public UserController(RestTemplate restTemplate, UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }


    @GetMapping("/{id}/weather")
    public ResponseEntity<Weather> getWeatherForPerson(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        Weather weather = restTemplate.getForObject("http://localhost:8081/locations?name=" + user.getLocation(), Weather.class);
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}