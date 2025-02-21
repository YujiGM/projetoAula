package com.fatec.projetoAula.projeto2025.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioControler {
    
    @GetMapping("")
    public String HelloWorld(){
        return "Hello World";
    }
}
