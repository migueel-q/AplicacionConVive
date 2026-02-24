package org.example.repositorios;

import org.example.modelos.Inquilino;
import org.example.modelos.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PisoRepositorio extends JpaRepository<Piso,Integer> {
    @Query("SELECT i FROM Inquilino i WHERE i.contrato.piso.propietario.id = :propietarioId")
    List<Inquilino> findInquilinosByPropietarioId(int propietarioId);

}
