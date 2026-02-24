package org.example.modelos;

import java.time.LocalDateTime;
import java.util.Objects;

public class InquilinoPropietarioId {
    private int inquilino;
    private int propietario;
    private LocalDateTime fechaMsg;
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
        InquilinoPropietarioId that = (InquilinoPropietarioId) o;
        return inquilino == that.inquilino && propietario == that.propietario && Objects.equals(fechaMsg, that.fechaMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilino, propietario, fechaMsg);
    }
}
