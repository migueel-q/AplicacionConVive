package org.example.servicios;

import org.example.DTO.PropietarioDTO;
import org.example.modelos.Propietario;

import java.util.List;

public interface PropietarioServicio {
    List<PropietarioDTO> obtenerPropietarios();
    PropietarioDTO obtenerPropietarioPorId(Integer id);
    Propietario guardar(Propietario propietario);
    Propietario actualizar(Propietario propietario, Integer id);
    Propietario eliminar(Integer id);
}
