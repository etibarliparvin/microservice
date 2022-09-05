package com.example.springcrudrestfulwebservice.controller;

import com.example.springcrudrestfulwebservice.entity.Person;
import com.example.springcrudrestfulwebservice.exception.ResourceNotFoundException;
import com.example.springcrudrestfulwebservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    @GetMapping
    public List<Person> getAllPeople() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id : " + id));
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable(value = "id") Long id) {
        Person existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id : " + id));
        existing.setName(person.getName());
        existing.setSurname(person.getSurname());
        existing.setEmail(person.getEmail());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable(value = "id") Long id) {
        Person existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id : " + id));
        repository.delete(existing);
        return ResponseEntity.ok().build();
    }
}
