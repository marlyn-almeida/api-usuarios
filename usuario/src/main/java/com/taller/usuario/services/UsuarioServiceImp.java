package com.taller.usuario.services;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }
}
