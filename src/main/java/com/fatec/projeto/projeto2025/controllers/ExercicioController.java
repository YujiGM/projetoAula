package com.fatec.projeto.projeto2025.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ExercicioController {

    @GetMapping("")
    public String HelloWorld1() {
        return "hello6";
    }

    @GetMapping("{nome}")
    public String HelloWorld(@PathVariable Optional<String> nome) {
        return nome.isPresent() ? nome.get() : "dd";
    }
   
    @GetMapping("/get-idade/{idade}")
    public String RetornaIdade(@PathVariable Integer idade) {
        try {
         if (idade < 0) {
            throw new NumberFormatException();
         }

         if (idade < 12 ) {
            return "Crianca";
         } else if (idade <= 18) {
            return "Adolescente";
         } else if (idade <= 60) {
            return "Adulto";
         } else {
            return "Idoso";
         }
            
        } catch (NumberFormatException e) {
            return "idade invalida";
        }
    }
}
