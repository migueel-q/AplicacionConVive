package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pisos")
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Embedded
    @Column(nullable = false)
    private Direccion direccion;
    @Column(nullable = false)
    private String descripcion;
    @Column(columnDefinition = "TEXT")
    private String url_imagen;
    @Column(nullable = false)
    private boolean disponible;
    @ManyToOne(fetch = FetchType.EAGER)
    Propietario propietario;
    private double precio;
    private boolean validado;



    public Piso() {
    }

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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String urlImagen) {
        this.url_imagen = urlImagen;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
}
