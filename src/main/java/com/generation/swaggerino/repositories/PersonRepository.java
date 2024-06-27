package com.generation.swaggerino.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.swaggerino.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>
{

}
