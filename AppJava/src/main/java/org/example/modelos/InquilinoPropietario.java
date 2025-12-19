package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@IdClass(InquilinoPropietarioId.class)
@Table(name = "inquilinos_propietarios")
public class InquilinoPropietario {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inquilino_id", nullable = false)
    private Inquilino inquilino;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="propietario_id", nullable = false)
    private Propietario propietario;
    @Id
    @Column(nullable = false)
    private LocalDateTime fecha_msg;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InquilinoPropietario that = (InquilinoPropietario) o;
        return Objects.equals(inquilino, that.inquilino) && Objects.equals(propietario, that.propietario) && Objects.equals(fecha_msg, that.fecha_msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquilino, propietario, fecha_msg);
    }
}
