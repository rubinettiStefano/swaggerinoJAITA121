package com.generation.swaggerino.controller;

import static com.generation.swaggerino.controller.EsempiResponseSwagger.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.swaggerino.model.Person;
import com.generation.swaggerino.repositories.PersonRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
public class TestController 
{
    @Autowired
    PersonRepository repo;

    @Operation(summary = "Lettura Stringhe", description = "API per leggere la lista di Stringhe")
    @GetMapping("/url1")
    public List<String> listaString() 
    {
        List<String> res = Arrays.asList("ciao,bye,pippo,pluto,paperino".split(","));
        return res;
    }

    @GetMapping("/url2")
    public List<Integer> listaInteri() 
    {
        List<Integer> res = Arrays.asList(3,5,12,98,64,15);
        return res;
    }


    // @Operation(summary = "Inserimento Persona",description = "Inserisce/Modifica una Persona sul Database e la restituisce con l'id autoassegnato")
    // @ApiResponses(
    //     value=
    //     {
    //         @ApiResponse
    //         (
    //             responseCode = "200", 
    //             description = "Persona Salvata e Restituita",
    //             content = @Content(mediaType = "application/json", examples = @ExampleObject(value = ESEMPIO_RESPONSE_INSERT_PERSON))
    //         ),
    //         @ApiResponse
    //         (
    //             responseCode = "400", 
    //             description = "Persona Non valida",
    //             content = @Content(mediaType = "text", examples = @ExampleObject(value = "La persona non va bene, controlla i dati, non sono riuscito a salvarla"))
    //         ),
    //     }
    // )
    // @PostMapping("/persons")
    // public ResponseEntity<?> insertPerson(@RequestBody Person toInsert) 
    // {
    //     try 
    //     {
    //             Person salvata = repo.save(toInsert);
    //             return new ResponseEntity<Person>(salvata,HttpStatus.OK);
    //     }
    //     catch (Exception e) 
    //     {
    //             return new ResponseEntity<String>(
    //                                                 "La persona non va bene, controlla i dati, non sono riuscito a salvarla",
    //                                                 HttpStatus.BAD_REQUEST
    //                                             );
    //     }


    // }
   
    
}
