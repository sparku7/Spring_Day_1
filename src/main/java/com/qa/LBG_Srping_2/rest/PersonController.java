package com.qa.LBG_Srping_2.rest;

import com.qa.LBG_Srping_2.entities.Person;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private List<Person> people = new ArrayList<>();

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.people;
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        this.people.add(person);
        return new ResponseEntity<>(this.people.get(this.people.size() - 1), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Person> removePerson(@PathVariable int id) {
        if (id < 0 || id >= this.people.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.people.remove(id), HttpStatus.OK);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id,
                                        @RequestParam (required = false) String name,
                                        @RequestParam (required = false) Integer age,
                                        @RequestParam (required = false) String job){

        if (id < 0 || id >= this.people.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       Person toUpdate = this.people.get(id);

       if (name != null) toUpdate.setName(name);
       if (age != null) toUpdate.setAge((age));
       if (job != null) toUpdate.setJob(job);

       return new ResponseEntity<>(toUpdate, HttpStatus.OK);
    }
}
