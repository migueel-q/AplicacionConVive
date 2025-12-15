package org.example.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario extends Usuario{
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Piso> pisos;
    @OneToMany(mappedBy = "propietario",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inquilino> inquilinos;     //Esta lista es la lista que recoge los inquilinos con los que habla el propietario
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "propietario_id")
    private List<Oferta> ofertas;

    public Propietario() {

    }

    public List<Inquilino> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(List<Inquilino> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(List<Piso> pisos) {
        this.pisos = pisos;
    }
}
