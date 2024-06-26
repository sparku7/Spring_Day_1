package com.qa.LBG_Spring_2.rest;

// Import statements for necessary classes and annotations

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.LBG_Spring_2.entities.Person;
import com.qa.LBG_Spring_2.entities.Pet;
import org.junit.jupiter.api.Test;
import org.mockito.plugins.MockMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

// Annotation to indicate that this is a Spring Boot integration test
@SpringBootTest
// Annotation to automatically configure MockMvc for web layer testing
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"})
public class PersonControllerMvcTest {

    @Autowired
    private MockMvc mvc; // MockMvc instance for simulating HTTP requests

    @Autowired
    private ObjectMapper mapper; // ObjectMapper for converting objects to/from JSON

    @Test
    void testCreatePerson() throws Exception {
        // Create a new Person object for testing
        Person newPerson = new Person(null, "Bob", 42, "Builder");
        // Convert the Person object to JSON format
        String newPersonAsJson = this.mapper.writeValueAsString(newPerson);
        // Build a POST request to create a new Person
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/person/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPersonAsJson);

        // Define a matcher to check if the HTTP status is OK (200)
        ResultMatcher checkStatus = MockMvcResultMatchers.status().is2xxSuccessful();
        // Create an expected Person object that should be returned after creation
        Person createdPerson = new Person(2, "Bob", 42, "Builder");
        // Convert the expected Person object to JSON format
        String createdPersonAsJson = this.mapper.writeValueAsString(createdPerson);

        // Define a matcher to check if the response body matches the expected JSON
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdPersonAsJson);

        // Perform the mock request using MockMvc and validate the expected results
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testCreatePet() throws Exception {
        // Create a new Person object for testing
        Pet newPet = new Pet(null, "Cat", "Harry", 8);
        // Convert the Person object to JSON format
        String newPetAsJson = this.mapper.writeValueAsString(newPet);
        // Build a POST request to create a new Person
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/pet/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPetAsJson);

        // Define a matcher to check if the HTTP status is OK (200)
        ResultMatcher checkStatus = MockMvcResultMatchers.status().is2xxSuccessful();
        // Create an expected Person object that should be returned after creation
        Pet createdPet = new Pet(2, "Cat", "Harry", 8);
        // Convert the expected Person object to JSON format
        String createdPetAsJson = this.mapper.writeValueAsString(createdPet);

        // Define a matcher to check if the response body matches the expected JSON
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdPetAsJson);

        // Perform the mock request using MockMvc and validate the expected results
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testGetID() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.get("/person/get/1");
        // Define a matcher to check if the HTTP status is OK (200)
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        // Create an expected Person object that should be returned after creation
        Person existing = new Person(1, "Alice", 30, "Engineer");
        // Convert the expected Person object to JSON format
        String existingPersonAsJson = this.mapper.writeValueAsString(existing);
        // Define a matcher to check if the response body matches the expected JSON
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingPersonAsJson);
        // Perform the mock request using MockMvc and validate the expected results
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testGetAll() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.get("/person/get/all");
        // Define a matcher to check if the HTTP status is OK (200)
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        // Create an expected Person object that should be returned after creation
        Person existing = new Person(1, "Alice", 30, "Engineer");
        List<Person> people = List.of(existing);
        // Convert the expected Person object to JSON format
        String peopleAsJson = this.mapper.writeValueAsString(people);
        // Define a matcher to check if the response body matches the expected JSON
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(peopleAsJson);
        // Perform the mock request using MockMvc and validate the expected results
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testDelete() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.delete("/person/remove/1");
        // Define a matcher to check if the HTTP status is OK (200)
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        // Define a matcher to check if the response body matches the expected JSON
        ResultMatcher checkBody = MockMvcResultMatchers.content().string("Person with id 1 has been deleted.");
        // Perform the mock request using MockMvc and validate the expected results
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testUpdate() throws Exception {

        Person updated = new Person(1, "Betty", 89, "Stripper");

        RequestBuilder mockRequest = MockMvcRequestBuilders.patch("/person/update/1")
                .queryParam("name", updated.getName())
                .queryParam("age", String.valueOf(updated.getAge()))
                .queryParam("job", updated.getJob());
        // Define a matcher to check if the HTTP status is OK (200)
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        // Convert the expected Person object to JSON format
        String updatedPersonAsJson = this.mapper.writeValueAsString(updated);
        // Define a matcher to check if the response body matches the expected JSON
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(updatedPersonAsJson);
        // Perform the mock request using MockMvc and validate the expected results
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testGetID404() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.get("/person/get/4");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher checkBody = MockMvcResultMatchers.content().string("No person found with id 4");
        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testRemoveID404() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.delete("/person/remove/4");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher checkBody = MockMvcResultMatchers.content().string("No person found with id 4");

        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }

    @Test
    void testUpdateID404() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.patch("/person/update/4");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher checkBody = MockMvcResultMatchers.content().string("No person found with id 4");

        this.mvc.perform(mockRequest)
                .andExpect(checkStatus)
                .andExpect(checkBody);
    }
}
