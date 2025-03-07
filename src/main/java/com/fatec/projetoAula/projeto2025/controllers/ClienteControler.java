package com.fatec.projetoAula.projeto2025.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.projetoAula.projeto2025.controllers.entities.Cliente;

@RestController

@RequestMapping("/api/cliente")

public class ClienteControler {
    
    //http://localhost:8080/api/cliente/cadastrarCliente -> POST
    @PostMapping("/cadastrarCliente")
    public String cadastrarCliente(@RequestBody Cliente cliente){      
        return "O cliente "+cliente.getNome()+" e idade "+cliente.getIdade()+" foi criado.";
    }
}
