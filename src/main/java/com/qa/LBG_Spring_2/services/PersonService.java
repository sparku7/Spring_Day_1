package com.qa.LBG_Spring_2.services;

import com.qa.LBG_Spring_2.entities.Person;
import com.qa.LBG_Spring_2.repos.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public List<Person> getAll() {
        return this.repo.findAll();
    }

    public Person get(int id) {
        Optional<Person> person = this.repo.findById(id);
        return person.orElse(null); // Handle the case where the person is not found
    }

    public Person createPerson(Person person) {
        return this.repo.save(person);
    }

    public Person updatePerson(int id, String name, Integer age, String job) {
        Person toUpdate = this.get(id);

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (job != null) toUpdate.setJob(job);

        return this.repo.save(toUpdate);
    }

    public Person removePerson(int id) {
     Person removed = this.get(id);
     this.repo.deleteById(id);
     return removed;
    }
}
