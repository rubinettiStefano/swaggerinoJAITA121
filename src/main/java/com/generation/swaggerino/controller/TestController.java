package com.generation.swaggerino.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController 
{
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

  
    
}
