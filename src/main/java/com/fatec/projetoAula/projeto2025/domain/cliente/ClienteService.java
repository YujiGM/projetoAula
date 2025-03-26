package com.fatec.projetoAula.projeto2025.domain.cliente;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils.Null;
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
        cli.setId(null);
        cli.setNome("Yuji");
        cli.setIdade(20);
        cli.setEndereco("Rua Fatec");

        return clienteRepository.save(cli);
    }

    public Optional<Cliente> getClientePorId(Integer id){
        return clienteRepository.findById(id);
    }

}
