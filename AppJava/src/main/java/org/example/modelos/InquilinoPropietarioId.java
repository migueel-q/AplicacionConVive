package org.example.modelos;

import java.time.LocalDateTime;
import java.util.Objects;

public class InquilinoPropietarioId {
    private int inquilino;
    private int propietario;
    private LocalDateTime fecha_msg;
    public InquilinoPropietarioId() {
    }

    public int getInquilino() {
        return inquilino;
    }

    public void setInquilino(int inquilino) {
        this.inquilino = inquilino;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    public LocalDateTime getFecha_msg() {
        return fecha_msg;
    }

    public void setFecha_msg(LocalDateTime fecha_msg) {
        this.fecha_msg = fecha_msg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPropietarioId that = (InquilinoPropietarioId) o;
        return inquilino == that.inquilino && propietario == that.propietario && Objects.equals(fecha_msg, that.fecha_msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilino, propietario, fecha_msg);
    }
}
