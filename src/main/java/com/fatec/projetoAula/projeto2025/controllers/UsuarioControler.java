package com.fatec.projetoAula.projeto2025.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {      
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuario();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable("id") Integer id) {
        ResponseEntity<Void> response = usuarioService.deletarUsuario(id);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Usuário removido com sucesso");
        }
        return ResponseEntity.status(response.getStatusCode()).body("Não existe usuário com id: " + id);
    }

    @GetMapping("/getUsuarioId/{id}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable Integer id) {
        ResponseEntity<Usuario> response = usuarioService.getUsuarioPorId(id);
        return response; // O método já retorna um ResponseEntity
    }

    @PutMapping("/putUsuarioId/{id}")
    public ResponseEntity<String> usuarioPut(@PathVariable("id") Integer id, @RequestBody Usuario usuarioAtualizado) {
        ResponseEntity<Boolean> response = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        }
        return ResponseEntity.status(response.getStatusCode()).body("Não existe usuário com id: " + id);
    }
}