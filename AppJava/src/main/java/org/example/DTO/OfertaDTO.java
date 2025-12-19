package org.example.DTO;

import org.example.modelos.Solicitud;

import java.util.List;

public class OfertaDTO {
    private int id;
    private double cantidad;
    private String descripcion;
    private int piso_id;
    private int inquilino_id;
    private List<Solicitud> solicitudes;

    public OfertaDTO(int id, double cantidad, String descripcion, int piso_id, int inquilino_id, List<Solicitud> solicitudes) {
        this.id = id;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.piso_id = piso_id;
        this.inquilino_id = inquilino_id;
        this.solicitudes = solicitudes;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPiso_id() {
        return piso_id;
    }

    public int getInquilino_id() {
        return inquilino_id;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public double getCantidad() {
        return cantidad;
    }
}
