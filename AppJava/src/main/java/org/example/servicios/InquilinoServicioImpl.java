package org.example.servicios;

import org.example.modelos.Inquilino;

import java.util.List;

public class InquilinoServicioImpl implements InquilinoServicio {
    @Override
    public List<Inquilino> obtenerInquilinos() {
        return List.of();
    }

    @Override
    public Inquilino obtenerInquilinoPorId(Integer id) {
        return null;
    }

    @Override
    public Inquilino guardar(Inquilino inquilino) {
        return null;
    }

    @Override
    public Inquilino actualizar(Inquilino inquilino, Integer id) {
        return null;
    }

    @Override
    public Inquilino eliminar(Integer id) {
        return null;
    }
}
