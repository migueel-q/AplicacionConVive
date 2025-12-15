package org.example.modelos;

import jakarta.persistence.*;
import org.example.InquilinoPisoId;

import java.time.LocalDateTime;

@Entity
@IdClass(InquilinoPisoId.class)
@Table(name = "inquilinos_pisos")
public class InquilinoPiso {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inquilino_id",insertable=false,updatable=false)
    private Inquilino inquilino;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="piso_id",insertable=false,updatable=false)
    private Piso piso;
    @Column(nullable = false)
    private LocalDateTime fechaInicioContrato;
    @Column(nullable = false)
    private LocalDateTime fechaFinContrato;
}
