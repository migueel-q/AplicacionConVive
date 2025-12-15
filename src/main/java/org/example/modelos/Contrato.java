package org.example.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private Inquilino inquilino;
    private Propietario propietario;
    private Piso piso;
}
