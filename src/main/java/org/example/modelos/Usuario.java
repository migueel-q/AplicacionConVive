package org.example.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
@MappedSuperclass
public abstract class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(unique = true,  nullable = false)
    protected String nombreUsuario;
    @Column(nullable = false)
    protected String nombreReal;
    @Column(nullable = false)
    protected LocalDate fechaNacimiento;
    @Column(unique = true,  nullable = false)
    protected String email;
    @Column(nullable = false)
    protected String password;

    public Usuario() {
    }
}
