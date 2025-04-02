package com.fatec.projetoAula.projeto2025.controllers;

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

import com.fatec.projetoAula.projeto2025.domain.usuario.UsuarioService;
import com.fatec.projetoAula.projeto2025.entities.Usuario;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControler {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrarUsuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {      
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuario();
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public String deletarUsuario(@PathVariable("id") Integer id) {
        boolean deletado = usuarioService.deletarUsuario(id);
        if (deletado) {
            return "Usuário removido com sucesso";
        }
        return "Não existe usuário com id: " + id;
    }

    @GetMapping("/getUsuarioId/{id}")
    public Optional<Usuario> getUsuarioPorId(@PathVariable Integer id) {
        return usuarioService.getUsuarioPorId(id);
    }

    @PutMapping("/putUsuarioId/{id}")
    public String usuarioPut(@PathVariable("id") Integer id, @RequestBody Usuario usuarioAtualizado) {
        boolean atualizado = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (atualizado) {
            return "Usuário atualizado com sucesso!";
        }
        return "Não existe usuário com id: " + id;
    }
}