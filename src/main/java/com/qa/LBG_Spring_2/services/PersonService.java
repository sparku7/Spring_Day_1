package com.qa.LBG_Spring_2.services;

import com.qa.LBG_Spring_2.entities.Person;
import com.qa.LBG_Spring_2.repos.PersonRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qa.LBG_Spring_2.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public List<PersonDto> getAll() {
        List<Person> found =  this.repo.findAll();
        List<PersonDto> dtos = new ArrayList<>();


        for (Person person : found) {
            dtos.add(new PersonDto(person));
        }

        return dtos;
    }

    public ResponseEntity<?> getPerson(Integer id) {
        if (!this.repo.existsById(id))
            return new ResponseEntity<>("No person found with id " + id, HttpStatus.NOT_FOUND);
        Person found = this.repo.findById(id).get();
        // missing not found logic
        return ResponseEntity.ok(new PersonDto(found));
    }

    public Person createPerson(Person person) {
        return this.repo.save(person);
    }

    public ResponseEntity<?> updatePerson(Integer id, String name, Integer age, String job) {
        Optional<Person> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No person found with id " + id, HttpStatus.NOT_FOUND);
        }

        Person toUpdate = found.get();
        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (job != null) toUpdate.setJob(job);

        Person updated = this.repo.save(toUpdate);
        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<?> removePerson(Integer id) {
        Optional<Person> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No person found with id " + id, HttpStatus.NOT_FOUND);
        }

        this.repo.deleteById(id);
        return ResponseEntity.ok("Person with id " + id + " has been deleted.");
    }
}
