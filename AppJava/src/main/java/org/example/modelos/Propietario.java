package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario extends Usuario{
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Piso> pisos;
    @OneToMany(mappedBy = "propietario",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<InquilinoPropietario> inquilinos;     //Esta lista es la lista que recoge los inquilinos con los que habla el propietario
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "propietario_id")
    @JsonIgnore
    private List<Oferta> ofertas;
    @OneToMany(mappedBy = "propietario",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Contrato> contratos;

    public Propietario() {

    }

    public List<InquilinoPropietario> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(List<InquilinoPropietario> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(List<Piso> pisos) {
        this.pisos = pisos;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "pisos=" + pisos +
                ", inquilinos=" + inquilinos +
                ", ofertas=" + ofertas +
                ", contratos=" + contratos +
                ", nombreUsuario='" + nombre_usuario + '\'' +
                ", nombreReal='" + nombre_real + '\'' +
                ", fechaNacimiento=" + fecha_nacimiento +
                ", email='" + email + '\'' +
                '}';
    }
}
