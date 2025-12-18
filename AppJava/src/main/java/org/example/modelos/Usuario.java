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

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
