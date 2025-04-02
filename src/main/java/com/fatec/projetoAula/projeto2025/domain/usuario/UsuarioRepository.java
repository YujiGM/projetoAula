package com.fatec.projetoAula.projeto2025.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.projetoAula.projeto2025.entities.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    
}
