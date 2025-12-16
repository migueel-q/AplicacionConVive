package org.example.modelos;

import java.util.Objects;

public class InquilinoPropietarioId {
    private int inquilinoId;
    private int propietarioId;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPropietarioId that = (InquilinoPropietarioId) o;
        return inquilino == that.inquilino && propietario == that.propietario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilino, propietario);
    }
}
