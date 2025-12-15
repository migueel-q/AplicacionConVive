package org.example.modelos;


import java.util.Objects;

public class InquilinoPropietarioId {
    private int inquilinoId;
    private int propietarioId;

    public InquilinoPropietarioId() {
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPropietarioId that = (InquilinoPropietarioId) o;
        return inquilinoId == that.inquilinoId && propietarioId == that.propietarioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilinoId, propietarioId);
    }
}
