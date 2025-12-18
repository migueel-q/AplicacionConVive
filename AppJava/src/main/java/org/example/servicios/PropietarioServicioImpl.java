package org.example.servicios;

import org.example.modelos.Propietario;

import java.util.List;

public class PropietarioServicioImpl implements PropietarioServicio {
    @Override
    public List<Propietario> obtenerPropietarios() {
        return List.of();
    }

    @Override
    public Propietario obtenerPropietarioPorId(Integer id) {
        return null;
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return null;
    }

    @Override
    public Propietario actualizar(Propietario propietario, Integer id) {
        return null;
    }

    @Override
    public Propietario eliminar(Integer id) {
        return null;
    }
}
