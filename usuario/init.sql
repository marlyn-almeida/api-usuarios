-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS usuarios;

-- Usar la base de datos
USE usuarios;

-- Crear la tabla `usuarios` alineada con la entidad
CREATE TABLE IF NOT EXISTS usuarios (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Campo ID autogenerado
                                        nombre VARCHAR(255) NOT NULL,         -- Nombre, obligatorio
    email VARCHAR(255) NOT NULL UNIQUE,   -- Email, obligatorio y único
    fecha_registro DATE,                  -- Fecha de registro, pasada o presente
    edad INT CHECK (edad BETWEEN 1 AND 100) -- Edad, entre 1 y 100
    );

-- Insertar datos de ejemplo
INSERT INTO usuarios (nombre, email, fecha_registro, edad)
VALUES
    ('Usuario Prueba 1', 'usuario1@example.com', CURDATE(), 25);

