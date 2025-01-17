package com.taller.usuario.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UsuConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir todas las solicitudes de cualquier origen (en desarrollo)
        registry.addMapping("/**") // Configura todas las rutas
                .allowedOrigins("http://localhost:80") // Aquí se coloca la URL de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permitir todos los headers
                .allowCredentials(true); //  es necesario enviar cookies o credenciales
    }
}
