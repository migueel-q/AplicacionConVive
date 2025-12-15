package org.example.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@IdClass(InquilinoPropietarioId.class)
@Table(name = "inquilinos_propietarios")
public class InquilinoPropietario {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inquilino_id",insertable=false,updatable=false)
    private Inquilino inquilino;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="propietario_id",insertable=false,updatable=false)
    private Propietario propietario;
    @Column(nullable = false)
    private LocalDateTime fechaMsg;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPropietario that = (InquilinoPropietario) o;
        return Objects.equals(inquilino, that.inquilino) && Objects.equals(propietario, that.propietario) && Objects.equals(fechaMsg, that.fechaMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilino, propietario, fechaMsg);
    }
}
