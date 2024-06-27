package com.qa.LBG_Spring_2.services;

import com.qa.LBG_Spring_2.entities.Pet;
import com.qa.LBG_Spring_2.repos.PetRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qa.LBG_Spring_2.dto.PetDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepo repo;

    public PetService(PetRepo repo) {
        this.repo = repo;
    }

    public List<PetDto> getAll() {
        List<PetDto> dtos = new ArrayList<>();
        List<Pet> found =  this.repo.findAll();
        for (Pet toy : found) {
            dtos.add(new PetDto(toy));
        }
        return dtos;
    }

    public ResponseEntity<?> getPet(Integer id) {
        Optional<Pet> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No pet found with id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(found.get());
    }

    public ResponseEntity<PetDto> createPet(Pet newPet) {
        Pet created = this.repo.save(newPet);

        return new ResponseEntity<>(new PetDto(created), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updatePet(Integer id, String type, String name, Integer age) {
        Optional<Pet> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No pet found with id " + id, HttpStatus.NOT_FOUND);
        }

        Pet toUpdate = found.get();
        if (type != null) toUpdate.setType(type);
        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);

        Pet updated = this.repo.save(toUpdate);
        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<?> removePet(Integer id) {
        Optional<Pet> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No pet found with id " + id, HttpStatus.NOT_FOUND);
        }

        this.repo.deleteById(id);
        return ResponseEntity.ok("Pet with id " + id + " has been deleted.");
    }
}
