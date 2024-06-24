package com.qa.LBG_Srping_2.entities;

public class Person {

    private String name;
    private int age;
    private String job;

    // Constructor to initialize the private properties
    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    // Getter method for the 'name' property
    public String getName() {
        return name;
    }

    // Setter method for the 'name' property
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the 'age' property
    public int getAge() {
        return age;
    }

    // Setter method for the 'age' property
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for the 'job' property
    public String getJob() {
        return job;
    }

    // Setter method for the 'job' property
    public void setJob(String job) {
        this.job = job;
    }
}
