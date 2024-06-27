package com.qa.LBG_Spring_2.rest;

// Import statements for Pet entity, PetService, and Spring Web annotations

import com.qa.LBG_Spring_2.entities.Pet;
import com.qa.LBG_Spring_2.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This annotation indicates that this class is a REST controller
@RestController
public class PetController {

    // Reference to the PetService to handle business logic
    private final PetService service;

    // Constructor to initialize the PetService
    public PetController(PetService service) {
        this.service = service;
    }

    // Endpoint to get all Pet records
    @GetMapping("pet/get/all")
    public List<Pet> getAll() {
        return this.service.getAll();
    }

    // Endpoint to get a specific Pet by their id
    @GetMapping("pet//get/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return this.service.getPet(id);
    }

    // Endpoint to create a new Pet record
    @PostMapping("pet/create")
    public Pet createPet(@RequestBody Pet pet) {
        return this.service.createPet(pet);
    }

    // Endpoint to delete a specific Pet by their id
    @DeleteMapping("pet/remove/{id}")
    public ResponseEntity<?> removePet(@PathVariable Integer id) {
        return this.service.removePet(id);
    }

    // Endpoint to update specific fields of a Pet record by their id
    @PatchMapping("pet/update/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Integer id,
                                          @RequestParam(required = false) String type,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) Integer age) {
        return this.service.updatePet(id, type, name, age);
    }
}
