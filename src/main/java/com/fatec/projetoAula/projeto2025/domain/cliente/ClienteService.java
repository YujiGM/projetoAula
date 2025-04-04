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

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public boolean atualizarCliente(Integer id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = getClientePorId(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setIdade(clienteAtualizado.getIdade());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            clienteRepository.save(cliente);
            return true;
        }
        return false;
    }

    public boolean deletarCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        
        return false;
    }

    public Optional<Cliente> getClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }
}
