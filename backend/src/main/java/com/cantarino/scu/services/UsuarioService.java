package com.cantarino.scu.services;

import com.cantarino.scu.entities.Usuario;
import com.cantarino.scu.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository _repository;

    final String pessoaJaCadastrada = "Pessoa já cadastrada";

    public List<Usuario> obterTodos() {
        return _repository.findAll();
    }

    public Usuario Criar(Usuario usuario) {
        JaCadastrado(usuario);
        return _repository.saveAndFlush(usuario);
    }

    private void JaCadastrado(Usuario usuario) {
        Optional<Usuario> _usuario = _repository.findByEmail(usuario.getEmail());
        if(_usuario.isPresent())
            throw new RuntimeException(pessoaJaCadastrada);
    }
}
