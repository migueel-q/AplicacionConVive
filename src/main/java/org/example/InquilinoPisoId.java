package org.example;

import java.util.Objects;

public class InquilinoPisoId {
    private int idInquilino;
    private int idPiso;

    public InquilinoPisoId() {
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPisoId that = (InquilinoPisoId) o;
        return idInquilino == that.idInquilino && idPiso == that.idPiso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInquilino, idPiso);
    }
}
