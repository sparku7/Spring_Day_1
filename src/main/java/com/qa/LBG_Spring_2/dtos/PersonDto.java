package com.qa.LBG_Spring_2.dto;

import java.util.ArrayList;
import java.util.List;
import com.qa.LBG_Spring_2.dto.PetDto;
import com.qa.LBG_Spring_2.entities.Person;
import com.qa.LBG_Spring_2.entities.Pet;

public class PersonDto {

    private Integer id;
    private String name;
    private int age;
    private String job;

    private List<PetDto> pets = new ArrayList<>();

    public PersonDto() {
        super();
        // Default constructor
    }

    public PersonDto(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.job = person.getJob();
        if (person.getPets() != null){
            for (Pet pet : person.getPets()){
                this.pets.add(new PetDto(pet));
            }
        }
    }

    public PersonDto(Integer id, String name, int age, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<PetDto> getPets() {
        return pets;
    }

    public void setPets(List<PetDto> pets) {
        this.pets = pets;
    }
}
