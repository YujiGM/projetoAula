package com.fatec.projetoAula.projeto2025.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.projetoAula.projeto2025.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
