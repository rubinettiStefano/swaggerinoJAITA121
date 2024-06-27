package com.generation.swaggerino.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.swaggerino.controller.exceptions.EntityNotFoundException;
import com.generation.swaggerino.model.Person;
import com.generation.swaggerino.repositories.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController 
{

    @Autowired
    PersonRepository repo;

    //LETTURA TUTTE ENTITÀ
    @GetMapping
    public List<Person> getAll()
    {
        return repo.findAll();
    }

    @GetMapping("/{id}") //localhost:8080/person/{id}
    public Person getOne(@PathVariable int id)
    {
        Optional<Person> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new EntityNotFoundException("Persona con id "+id+" non trovata");

        return opt.get();
    }

}
