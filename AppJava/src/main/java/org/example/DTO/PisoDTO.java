package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.modelos.*;

import java.util.List;

public class PisoDTO {
    private int id;
    private Direccion direccion;
    private String descripcion;
    private String url_imagen;
    private boolean disponible;
    private List<Oferta> ofertas;
    private List<Gasto> gastos;
    private List<Contrato> contratos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public PisoDTO(int id, Direccion direccion, String descripcion, String url_imagen, boolean disponible, List<Oferta> ofertas, List<Gasto> gastos, List<Contrato> contratos) {
        this.id = id;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
        this.disponible = disponible;
        this.ofertas = ofertas;
        this.gastos = gastos;
        this.contratos = contratos;
    }

}
