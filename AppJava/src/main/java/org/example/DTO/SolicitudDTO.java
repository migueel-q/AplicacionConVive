package org.example.DTO;

public class SolicitudDTO {
    private int id;
    private int inquilinoId;
    private int ofertaId;
    private boolean aceptado;

    public SolicitudDTO(int id, int inquilinoId, int ofertaId, boolean aceptado) {
        this.id = id;
        this.inquilinoId = inquilinoId;
        this.ofertaId = ofertaId;
        this.aceptado = aceptado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }
}
