package ru.andreev.task15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.andreev.task15.model.Person;
import ru.andreev.task15.repository.PersonRepository;

import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> findPersonById(@PathVariable long id) {
        return personRepository.findById(id);
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person person) {
        person.setId(id);
        personRepository.save(person);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);
    }
}
