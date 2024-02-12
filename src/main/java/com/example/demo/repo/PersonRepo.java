package com.example.demo.repo;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    @Query("SELECT lastName FROM Person a WHERE lastName like '%t%'")
    List<String> getFilteredUsers();
}
