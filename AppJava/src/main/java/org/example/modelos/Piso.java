package org.example.modelos;

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
    private String urlImagen;
    @Column(nullable = false)
    private boolean disponible;
    @OneToMany(mappedBy = "piso")
    List<Inquilino> inquilinos;
    @ManyToOne
    Propietario propietario;
    @OneToMany(mappedBy = "piso",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> ofertas;
    @OneToMany(mappedBy = "piso",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gasto> gastos;
    @OneToMany(mappedBy = "piso",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos;

    @Override
    public String toString() {
        return "Piso{" +
                "id=" + id +
                ", direccion=" + direccion +
                ", descripcion='" + descripcion + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                ", disponible=" + disponible +
                ", inquilinos=" + inquilinos +
                ", propietario=" + propietario +
                ", ofertas=" + ofertas +
                ", gastos=" + gastos +
                ", contratos=" + contratos +
                '}';
    }

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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public List<Inquilino> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(List<Inquilino> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
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
}
