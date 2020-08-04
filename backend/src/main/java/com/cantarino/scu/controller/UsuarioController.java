package com.cantarino.scu.controller;


import com.cantarino.scu.entities.Usuario;
import com.cantarino.scu.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;


    @GetMapping("/api/usuario")
    public List<Usuario> All() {
        return  _usuarioService.obterTodos();
    }

    @PostMapping("/api/usuario")
    public ResponseEntity Criar(@RequestBody  Usuario usuario) {
        try
        {
            return ResponseEntity.ok().body(_usuarioService.Criar(usuario));
        }
        catch (RuntimeException ex)
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(ex.getMessage());
        }
    }
}
