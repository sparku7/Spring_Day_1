package com.qa.LBG_Spring_2.entities;

import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "person_id") // Specifies the foreign key column
    private Person person;

    // No-argument constructor required by JPA
    public Pet() {
    }

    // Parameterized constructor for initializing fields
    public Pet(Integer id, String type, String name, Integer age, Person person) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.person = person;
    }

    // Getter and setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
