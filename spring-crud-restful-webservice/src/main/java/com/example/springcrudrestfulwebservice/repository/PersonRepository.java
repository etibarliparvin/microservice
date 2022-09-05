package com.example.springcrudrestfulwebservice.repository;

import com.example.springcrudrestfulwebservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
