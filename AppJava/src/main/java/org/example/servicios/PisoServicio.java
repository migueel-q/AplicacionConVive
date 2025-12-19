package org.example.servicios;

import org.example.DTO.PisoDTO;
import org.example.modelos.Piso;

import java.util.List;

public interface PisoServicio {
    public List<PisoDTO> obtenerPisos();
    public PisoDTO obtenerPisoPorId(Integer id);
    public Piso guardar(Piso piso);
    public Piso actualizar(Piso piso, Integer id);
    public Piso eliminar(Integer id);
}
