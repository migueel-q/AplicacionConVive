package org.example.servicios;

import org.example.modelos.Piso;

import java.util.List;

public class PisoServicioImpl implements  PisoServicio {
    @Override
    public List<Piso> obtenerPisos() {
        return List.of();
    }

    @Override
    public Piso obtenerPisoPorId(Integer id) {
        return null;
    }

    @Override
    public Piso guardar(Piso piso) {
        return null;
    }

    @Override
    public Piso actualizar(Piso piso, Integer id) {
        return null;
    }

    @Override
    public Piso eliminar(Integer id) {
        return null;
    }
}
