package com.taller.usuario.services;

import com.taller.usuario.model.entities.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    /**
     * Obtiene la lista de todos los usuarios.
     * @return Lista de usuarios.
     */
    List<Usuario> obtenerTodos();

    /**
     * Guarda un usuario en la base de datos.
     * @param usuario El usuario a guardar.
     * @return El usuario guardado.
     */
    Usuario guardar(Usuario usuario);

    /**
     * Busca un usuario por su ID.
     * @param id El ID del usuario.
     * @return Un Optional con el usuario si se encuentra.
     */
    Optional<Usuario> obtenerPorId(int id);

    /**
     * Elimina un usuario por su ID.
     * @param id El ID del usuario a eliminar.
     */
    void eliminar(int id);
}
