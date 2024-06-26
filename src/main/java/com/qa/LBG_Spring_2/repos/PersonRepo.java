package com.qa.LBG_Spring_2.repos;

// Import statements for the Person entity, JpaRepository, and Repository annotation
import com.qa.LBG_Spring_2.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This annotation indicates that this interface is a Spring repository
@Repository
// This interface extends JpaRepository to provide CRUD operations for the Person entity
public interface PersonRepo extends JpaRepository<Person, Integer> {
    // JpaRepository provides basic CRUD methods, so no additional code is needed here
    // The Person entity type is specified, and Integer is the type of its primary key
}
