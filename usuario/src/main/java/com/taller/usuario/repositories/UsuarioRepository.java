package com.taller.usuario.repositories;

import org.springframework.data.repository.CrudRepository;
import com.taller.usuario.model.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
}
