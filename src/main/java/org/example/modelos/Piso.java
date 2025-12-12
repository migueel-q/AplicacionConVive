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
    private Direccion direccion;
    @Column(nullable = false)
    private String descripcion;
    private String urlImagen;
    @OneToMany(mappedBy = "piso", cascade = CascadeType.ALL)
    List<Inquilino> inquilinos;
    @ManyToOne
    Propietario propietario;

    public Piso() {
    }

}
