package org.example.servicios;

import org.example.DTO.TareaDTO;
import org.example.modelos.Tarea;

import java.util.List;

public interface TareaServicio {
    List<TareaDTO> obtenerTareas();
    TareaDTO obtenerTareaPorId(Integer id);
    Tarea guardar(Tarea tarea);
    Tarea actualizar(Tarea tarea,Integer id);
    Tarea eliminar(Integer id);

}
