package org.example.servicios;

import org.example.DTO.TareaDTO;
import org.example.modelos.Tarea;
import org.example.repositorios.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicioImpl implements  TareaServicio {
    @Autowired
    private TareaRepositorio tareaRepositorio;
    @Override
    public List<Tarea> obtenerTareas() {
        return tareaRepositorio.findAll();
    }

    @Override
    public Tarea obtenerTareaPorId(Integer id) {
        return tareaRepositorio.findById(id).orElse(null);
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepositorio.save(tarea);
    }

    @Override
    public Tarea actualizar(Tarea tarea, Integer id) {
        if (tareaRepositorio.existsById(id)) {
            tarea.setId(id);
            return tareaRepositorio.save(tarea);
        } else{
            return null;
        }
    }

    @Override
    public Tarea eliminar(Integer id) {
        if (tareaRepositorio.existsById(id)) {
            Tarea tarea = tareaRepositorio.findById(id).get();
            tareaRepositorio.delete(tarea);
            return tarea;
        } else{
            return null;
        }
    }
}
