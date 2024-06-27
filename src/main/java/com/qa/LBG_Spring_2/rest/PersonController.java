package com.qa.LBG_Spring_2.rest;

// Import statements for Person entity, PersonService, and Spring Web annotations

import com.qa.LBG_Spring_2.entities.Person;
import com.qa.LBG_Spring_2.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.qa.LBG_Spring_2.dto.PersonDto;

import java.util.List;

// This annotation indicates that this class is a REST controller
@RestController
public class PersonController {

    // Reference to the PersonService to handle business logic
    private final PersonService service;

    // Constructor to initialize the PersonService
    public PersonController(PersonService service) {
        this.service = service;
    }

    // Endpoint to get all Person records
    @GetMapping("/person/get/all")
    public List<PersonDto> getAll() {
        return this.service.getAll();
    }

    // Endpoint to get a specific Person by their id
    @GetMapping("/person/get/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return this.service.getPerson(id);
    }

    // Endpoint to create a new Person record
    @PostMapping("/person/create")
    public Person createPerson(@RequestBody Person person) {
        return this.service.createPerson(person);
    }

    // Endpoint to delete a specific Person by their id
    @DeleteMapping("/person/remove/{id}")
    public ResponseEntity<?> removePerson(@PathVariable Integer id) {
        return this.service.removePerson(id);
    }

    // Endpoint to update specific fields of a Person record by their id
    @PatchMapping("/person/update/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Integer id,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) String job) {
        return this.service.updatePerson(id, name, age, job);
    }
}
