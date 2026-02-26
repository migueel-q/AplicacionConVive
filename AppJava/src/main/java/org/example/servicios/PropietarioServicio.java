package org.example.servicios;

import org.example.DTO.PropietarioDTO;
import org.example.modelos.Propietario;

import java.util.List;

public interface PropietarioServicio {
    List<Propietario> obtenerPropietarios();
    Propietario obtenerPropietarioPorId(Integer id);
    Propietario guardar(Propietario propietario);
    Propietario actualizar(Propietario propietario, Integer id);
    Propietario eliminar(Integer id);
    Propietario buscarPorCorreo(String email);
}
