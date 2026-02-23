package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "inquilinos")
public class Inquilino extends Usuario {

    private LocalDateTime fecha_alta;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("piso-inquilinos")
    private Piso piso;
    @ManyToOne(fetch = FetchType.EAGER)
    private Contrato contrato;

    public Inquilino() {
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public LocalDateTime getFechaAlta() {
        return fecha_alta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fecha_alta = fechaAlta;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "nombreUsuario='" + nombre_usuario + '\'' +
                ", nombreReal='" + nombre_real + '\'' +
                ", fechaNacimiento=" + fecha_nacimiento +
                ", email='" + email + '\'' +
                ", piso=" + piso +
                '}';
    }
}
