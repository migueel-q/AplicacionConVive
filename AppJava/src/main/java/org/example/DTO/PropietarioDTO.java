package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.example.modelos.Contrato;
import org.example.modelos.InquilinoPropietario;
import org.example.modelos.Oferta;
import org.example.modelos.Piso;

import java.time.LocalDate;
import java.util.List;

public class PropietarioDTO {
    private int id;
    private String nombre_usuario;
    private String nombre_real;
    private LocalDate fecha_nacimiento;
    private String email;
    private List<Piso> pisos;
    private List<InquilinoPropietario> inquilinos;
    private List<Oferta> ofertas;
    private List<Contrato> contratos;

    public PropietarioDTO(int id, String nombre_usuario, String nombre_real, LocalDate fecha_nacimiento, String email) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.nombre_real = nombre_real;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
    }

    public PropietarioDTO(int id, String nombre_usuario, String nombre_real, LocalDate fecha_nacimiento, String email, List<Piso> pisos, List<InquilinoPropietario> inquilinos, List<Oferta> ofertas, List<Contrato> contratos) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.nombre_real = nombre_real;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.pisos = pisos;
        this.inquilinos = inquilinos;
        this.ofertas = ofertas;
        this.contratos = contratos;
    }

    public int getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public List<InquilinoPropietario> getInquilinos() {
        return inquilinos;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }
}
