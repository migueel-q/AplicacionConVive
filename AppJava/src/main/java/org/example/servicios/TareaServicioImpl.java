package org.example.servicios;

import org.example.modelos.Tarea;

import java.util.List;

public class TareaServicioImpl implements  TareaServicio {
    @Override
    public List<Tarea> obtenerTareas() {
        return List.of();
    }

    @Override
    public Tarea obtenerTareaPorId(Integer id) {
        return null;
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return null;
    }

    @Override
    public Tarea actualizar(Tarea tarea, Integer id) {
        return null;
    }

    @Override
    public Tarea eliminar(Tarea tarea) {
        return null;
    }
}
