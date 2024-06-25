package com.qa.LBG_Srping_2.services;

import com.qa.LBG_Srping_2.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final List<Person> people = new ArrayList<>();

    public List<Person> getAll() {return this.people;}

    public Person createPerson(Person person) {
        this.people.add(person);
        return this.people.get(this.people.size() - 1);
    }

    public Person removePerson(int id) {
        if (id >= 0 && id < people.size()) {
            return this.people.remove(id);
        }
        return null;
    }

    public Person updatePerson(int id, String name, Integer age, String job) {
        if (id >= 0 && id < people.size()) {
            Person toUpdate = this.people.get(id);

            if (name != null) toUpdate.setName(name);
            if (age != null) toUpdate.setAge(age);
            if (job != null) toUpdate.setJob(job);

            return toUpdate;
        }
        return null;
    }
}
