package org.example.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gastos")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String concepto;
    @Column(nullable = false)
    private double valor;
    @ManyToOne
    private Inquilino inquilino;
    @ManyToOne
    private Piso piso;

    public Gasto() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }
}
