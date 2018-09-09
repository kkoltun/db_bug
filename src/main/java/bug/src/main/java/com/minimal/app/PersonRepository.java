package com.minimal.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

  @Query(value = "SELECT * FROM person p WHERE p.first_name = ?1", nativeQuery = true)
  Optional<Person> findByFirstName(String firstName);
}
