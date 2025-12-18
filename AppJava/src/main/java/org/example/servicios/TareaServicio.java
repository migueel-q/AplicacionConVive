package org.example.servicios;

import org.example.modelos.Tarea;

import java.util.List;

public interface TareaServicio {
    public List<Tarea> obtenerTareas();
    public Tarea obtenerTareaPorId(Integer id);
    public Tarea guardar(Tarea tarea);
    public Tarea actualizar(Tarea tarea,Integer id);
    public Tarea eliminar(Integer id);

}
