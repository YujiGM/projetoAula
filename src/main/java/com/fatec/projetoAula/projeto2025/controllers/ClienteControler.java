package com.fatec.projetoAula.projeto2025.controllers;

import java.util.ArrayList;
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

import com.fatec.projetoAula.projeto2025.domain.cliente.ClienteService;
import com.fatec.projetoAula.projeto2025.entities.Cliente;

@RestController

@RequestMapping("/api/cliente")

public class ClienteControler {

    @Autowired
    private ClienteService clienteService;
    
    private final List<Cliente> clientes = new ArrayList<>();
    private Integer idCount = 1;



    
    //http://localhost:8080/api/cliente/cadastrarCliente -> POST
    @PostMapping("/cadastrarCliente")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){      
        return clienteService.cadastrarCliente(cliente);

    }

    //http://localhost:8080/api/cliente/listarCLientes -> GET  
    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarCliente();
    }

    //http://localhost:8080/api/cliente//deletarCliente/{id} -> Delete      
    
    @DeleteMapping("/deletarCliente/{id}")
    public String deletarCliente(@PathVariable("id") Integer id){
        for(Cliente cliente : clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                return "O cliente " + cliente.getNome() + " foi removido.";
            }
        }
        return "Não existe cliente com id: "+ id;
    }

    @GetMapping("/getClienteId/{id}")
    public Optional<Cliente> getClientePorId(@PathVariable Integer id){
       return clienteService.getClientePorId(id);
    }

    @PutMapping("/putClienteId/{id}")
    public String clientePut(@PathVariable("id") Integer id) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getId().equals(id)) {
                cliente.setNome("Jorge");
                cliente.setIdade(11);
                cliente.setEndereco("Tatuí - SP");
                return "O cliente atualizado com sucesso!";
            }
        }
        return "Não existe cliente com id: " + id;
    }
}
