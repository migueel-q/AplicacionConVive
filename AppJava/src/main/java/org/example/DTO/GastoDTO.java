package org.example.DTO;

public class GastoDTO {
    private int id;
    private String concepto;
    private double valor;
    private int inquilinoId;
    private int pisoId;

    public GastoDTO(int id, String concepto, double valor, int inquilinoId, int pisoId) {
        this.id = id;
        this.concepto = concepto;
        this.valor = valor;
        this.inquilinoId = inquilinoId;
        this.pisoId = pisoId;
    }

    public int getId() {
        return id;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getValor() {
        return valor;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public int getPisoId() {
        return pisoId;
    }
}
