package com.qa.LBG_Spring_2.entities;

// Import statements for JPA (Java Persistence API) annotations

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class Person {

    // This annotation specifies the primary key of an entity.
    @Id
    // This annotation provides for the specification of generation strategies for the values of primary keys.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Field to store the unique identifier for each person
    private String name; // Field to store the name of the person
    private int age;     // Field to store the age of the person
    private String job;  // Field to store the job title of the person

    // Default constructor - required by JPA
    public Person() {

    }

    // Parameterized constructor to initialize a new Person object with specified values
    public Person(Integer id, String name, int age, String job) {
        this.id = id;     // Initialize the id field
        this.name = name; // Initialize the name field
        this.age = age;   // Initialize the age field
        this.job = job;   // Initialize the job field
    }

    // Getter method for id field
    public Integer getId() {
        return id;
    }

    // Setter method for id field
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter method for name field
    public String getName() {
        return name;
    }

    // Setter method for name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age field
    public int getAge() {
        return age;
    }

    // Setter method for age field
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for job field
    public String getJob() {
        return job;
    }

    // Setter method for job field
    public void setJob(String job) {
        this.job = job;
    }
}
