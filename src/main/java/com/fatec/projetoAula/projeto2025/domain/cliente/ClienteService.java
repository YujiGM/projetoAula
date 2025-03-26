package com.fatec.projetoAula.projeto2025.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.projetoAula.projeto2025.entities.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;  
    
    public List<Cliente> listarCLientes(Cliente idCliente){
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente (Cliente cliente){
        return clienteRepository.save(cliente);
    }
}

