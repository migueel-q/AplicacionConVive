package org.example.DTO;


import org.example.modelos.Inquilino;
import org.example.modelos.Piso;
import org.example.modelos.Propietario;

import java.time.LocalDate;
import java.util.List;

public class ContratoDTO {
    private int id;
    private String descripcion;
    private double precio;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private List<Inquilino> inquilinos;
    private int propietario_id;
    private int piso_id;

    public ContratoDTO(int id, String descripcion, double precio, LocalDate fecha_inicio, LocalDate fecha_fin, List<Inquilino> inquilinos, int propietario_id, int piso_id) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.inquilinos = inquilinos;
        this.propietario_id = propietario_id;
        this.piso_id = piso_id;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public int getPropietario_id() {
        return propietario_id;
    }

    public int getPiso_id() {
        return piso_id;
    }

    public List<Inquilino> getInquilinos() {
        return inquilinos;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }
}
