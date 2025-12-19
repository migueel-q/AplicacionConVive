package org.example.DTO;

import org.example.modelos.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class InquilinoDTO {
    private int id;
    private String nombre_usuario;
    private String nombre_real;
    private LocalDate fecha_nacimiento;
    private String email;
    private LocalDateTime fecha_alta;
    private int piso_id;
    private List<Tarea> tareas;
    private List<Oferta> ofertas;
    private List<Solicitud> solicitudes;
    private List<Gasto> gastos;
    private List<InquilinoPropietario> propietarios;
    private int contrato_id;

    public InquilinoDTO(int id, String nombre_usuario, String nombre_real, LocalDate fecha_nacimiento, String email, LocalDateTime fecha_alta) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.nombre_real = nombre_real;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.fecha_alta = fecha_alta;
    }

    public InquilinoDTO(int id, String nombre_usuario, String nombre_real, LocalDate fecha_nacimiento, String email, LocalDateTime fecha_alta, int piso_id, List<Tarea> tareas, List<Oferta> ofertas, List<Solicitud> solicitudes, List<Gasto> gastos, List<InquilinoPropietario> propietarios, int contrato_id) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.nombre_real = nombre_real;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.fecha_alta = fecha_alta;
        this.piso_id = piso_id;
        this.tareas = tareas;
        this.ofertas = ofertas;
        this.solicitudes = solicitudes;
        this.gastos = gastos;
        this.propietarios = propietarios;
        this.contrato_id = contrato_id;
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

    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    public int getPiso_id() {
        return piso_id;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public List<InquilinoPropietario> getPropietarios() {
        return propietarios;
    }

    public int getContrato_id() {
        return contrato_id;
    }
}
