package com.taller.usuario.model.entities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;



@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Email no válido")
    private String email;

    @PastOrPresent(message = "La fecha de registro debe ser pasada o presente")
    private Date fechaRegistro;

    @Min(value = 18, message = "La edad mínima es 18")
    @Max(value = 120, message = "La edad máxima es 120")
    private int edad;


}