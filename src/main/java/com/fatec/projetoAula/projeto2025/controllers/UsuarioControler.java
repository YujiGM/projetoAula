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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.projetoAula.projeto2025.domain.usuario.UsuarioService;
import com.fatec.projetoAula.projeto2025.entities.Usuario;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController

@RequestMapping("/api/usuario")

public class UsuarioControler {
    
    @Autowired
    private UsuarioService usuarioService;
    
    private final List<Usuario> usuarios = new ArrayList<>();
    private Integer idCount = 1;



    
    //http://localhost:8080/api/usuario/cadastrarUsuario -> POST
    @PostMapping("/cadastrarUsuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){      
        return usuarioService.cadastrarUsuario(usuario);

    }

    //http://localhost:8080/api/usuarios/listarUsuarios -> GET  
    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuario();
    }

    //http://localhost:8080/api/usuarios/deletarUsuario/{id} -> Delete      
    @DeleteMapping("/deletarUsuario/{id}")
    public String deletarUsuario(@PathVariable("id") Integer id){
        for(Usuario usuario : usuarios){
            if(usuario.getId().equals(id)){
                usuarios.remove(usuario);
                return "O usuario " + usuario.getNome() + " foi removido.";
            }
        }
        return "Não existe usuario com id: "+ id;
    }

    @GetMapping("/getUsuarioId/{id}")
    public Optional<Usuario> getUsuarioPorId(@PathVariable Integer id){
       return usuarioService.getUsuarioPorId(id);
    }

    @PutMapping("/putUsuarioId/{id}")
    public String usuarioPut(@PathVariable("id") Integer id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId().equals(id)) {
                usuario.setNome("Jorge");
                usuario.setEmail("Tatuí - SP");
                return "O usuario atualizado com sucesso!";
            }
        }
        return "Não existe usuario com id: " + id;
    }
}
