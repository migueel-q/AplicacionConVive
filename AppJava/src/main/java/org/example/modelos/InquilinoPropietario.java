package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@IdClass(InquilinoPropietarioId.class)
@Table(name = "inquilinos_propietarios")
public class InquilinoPropietario {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="inquilino_id", nullable = false)
    private Inquilino inquilino;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="propietario_id", nullable = false)
    private Propietario propietario;
    @Id
    @Column(nullable = false, name = "fecha_msg")
    private LocalDateTime fechaMsg;

    @Column(nullable = false)
    private String mensaje;


    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public LocalDateTime getFechaMsg() {
        return fechaMsg;
    }

    public void setFechaMsg(LocalDateTime fechaMsg) {
        this.fechaMsg = fechaMsg;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPropietario that = (InquilinoPropietario) o;
        return Objects.equals(inquilino, that.inquilino) && Objects.equals(propietario, that.propietario) && Objects.equals(fechaMsg, that.fechaMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilino, propietario, fechaMsg);
    }
}
