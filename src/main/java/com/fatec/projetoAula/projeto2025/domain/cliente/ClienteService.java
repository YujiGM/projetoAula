package com.fatec.projetoAula.projeto2025.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.projetoAula.projeto2025.entities.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> listarCliente(){
            return clienteRepository.findAll();
        }
    
    public Cliente cadastrarCliente(Cliente cliente){
        var cli = new Cliente();
        cli.setId(0);
        cli.setNome("ddd");
        cli.setIdade(1);
        cli.setEndereco("sss");

        return clienteRepository.save(cli);
    }

}
