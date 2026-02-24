package org.example.repositorios;

import org.example.modelos.InquilinoPropietario;
import org.example.modelos.InquilinoPropietarioId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepositorio extends JpaRepository<InquilinoPropietario, InquilinoPropietarioId> {
    List<InquilinoPropietario> findByInquilinoIdAndPropietarioIdOrderByFechaMsgAsc(int inquilinoId, int propietarioId );
}
