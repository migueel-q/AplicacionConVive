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
    private String url_imagen;
    @Column(nullable = false)
    private boolean disponible;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("propietario-pisos")
    Propietario propietario;



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
}
