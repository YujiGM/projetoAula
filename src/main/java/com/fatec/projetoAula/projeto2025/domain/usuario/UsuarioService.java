package com.fatec.projetoAula.projeto2025.domain.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.projetoAula.projeto2025.entities.Usuario;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public ResponseEntity<Usuario> cadastrarUsuario(Usuario usuario) {
        usuario.setId(null);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    public ResponseEntity<Boolean> atualizarUsuario(Integer id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            
            if (usuarioAtualizado.getNome() != null) {
                usuarioExistente.setNome(usuarioAtualizado.getNome());
            }
            
            if (usuarioAtualizado.getEmail() != null) {
                usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            }
            
            usuarioRepository.save(usuarioExistente);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    public ResponseEntity<Void> deletarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Usuario> getUsuarioPorId(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
    }
}