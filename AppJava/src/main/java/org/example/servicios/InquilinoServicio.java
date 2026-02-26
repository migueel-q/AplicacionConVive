package org.example.servicios;

import org.example.DTO.InquilinoDTO;
import org.example.modelos.Inquilino;

import java.util.List;

public interface InquilinoServicio {
    List<Inquilino> obtenerInquilinos();
    Inquilino obtenerInquilinoPorId(Integer id);
    Inquilino guardar(Inquilino inquilino);
    Inquilino actualizar(Inquilino inquilino, Integer id);
    Inquilino eliminar(Integer id);
    Inquilino buscarPorCorreo(String email);
}
