package com.taller.usuario.controllers;

import com.taller.usuario.model.entities.Usuario;
import com.taller.usuario.services.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5500")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImp usuarioService;

    // Método para crear un usuario
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errores = new ArrayList<>();
            // Recoger los errores de validación
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores); // Devolver los errores con un código 400
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario));
    }

    // Método para listar todos los usuarios
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.obtenerTodos();
    }

    // Método para buscar un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.obtenerPorId(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok().body(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Método para editar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            List<String> errores = new ArrayList<>();
            // Recoger los errores de validación
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores); // Devolver los errores con un código 400
        }

        Optional<Usuario> usuarioOptional = usuarioService.obtenerPorId(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioDB = usuarioOptional.get();
            usuarioDB.setNombre(usuario.getNombre());
            usuarioDB.setEmail(usuario.getEmail());
            usuarioDB.setFechaRegistro(usuario.getFechaRegistro());
            usuarioDB.setEdad(usuario.getEdad());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuarioDB));
        }
        return ResponseEntity.notFound().build();
    }

    // Método para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
