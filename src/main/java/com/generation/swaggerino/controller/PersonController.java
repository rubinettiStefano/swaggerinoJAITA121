package com.generation.swaggerino.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.swaggerino.controller.exceptions.EntityNotFoundException;
import com.generation.swaggerino.controller.exceptions.NotNewEntityException;
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

    @PostMapping
    public Person insert(@RequestBody Person toInsert)
    {
        if(toInsert.getId()!=null)
            throw new NotNewEntityException("La tua persona ha un id, non è nuova");
        
        return repo.save(toInsert);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable int id,@RequestBody Person toUpdate)
    {
        Optional<Person> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new EntityNotFoundException("Persona con id "+id+" non trovata");
        
        toUpdate.setId(id);

        return repo.save(toUpdate);
    }

    @DeleteMapping("/{id}")
    public Person delete(@PathVariable int id)
    {
        Optional<Person> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new EntityNotFoundException("Persona con id "+id+" non trovata");
        

        repo.deleteById(id);

        return opt.get();
    }

}
