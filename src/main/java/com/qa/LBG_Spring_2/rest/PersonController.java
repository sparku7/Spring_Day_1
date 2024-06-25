package com.qa.LBG_Spring_2.rest;

import com.qa.LBG_Spring_2.entities.Person;
import com.qa.LBG_Spring_2.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {return this.service.getAll();}

    @GetMapping("/get{id}")
    public Person get(@PathVariable Integer id){return this.service.get(id);    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {return this.service.createPerson(person);    }

    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id) { return this.service.removePerson(id);}

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) Integer age,
                               @RequestParam(required = false) String job) {
        return this.service.updatePerson(id, name, age, job);
    }
}
