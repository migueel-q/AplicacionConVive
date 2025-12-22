package org.example.servicios;

import org.example.DTO.PisoDTO;
import org.example.modelos.Piso;

import java.util.List;

public interface PisoServicio {
    List<PisoDTO> obtenerPisos();
    PisoDTO obtenerPisoPorId(Integer id);
    Piso guardar(Piso piso);
    Piso actualizar(Piso piso, Integer id);
    Piso eliminar(Integer id);
}
