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
    protected String nombre_usuario;
    @Column(nullable = false)
    protected String nombre_real;
    @Column(nullable = false)
    protected LocalDate fecha_nacimiento;
    @Column(unique = true,  nullable = false)
    protected String email;
    @Column(nullable = false)
    protected String password;

    public Usuario() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombreUsuario) {
        this.nombre_usuario = nombreUsuario;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public void setNombre_real(String nombreReal) {
        this.nombre_real = nombreReal;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fechaNacimiento) {
        this.fecha_nacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
