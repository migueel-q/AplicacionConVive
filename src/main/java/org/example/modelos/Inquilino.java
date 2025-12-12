package org.example.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquilinos")
public class Inquilino extends Usuario {
    @ManyToOne
    private Piso piso;

    public Inquilino() {
    }
}
