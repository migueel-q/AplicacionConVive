package org.example.servicios;

import org.example.modelos.Solicitud;

import java.util.List;

public class SolicitudServicioImpl implements  SolicitudServicio {
    @Override
    public List<Solicitud> obtenerSolicitudes() {
        return List.of();
    }

    @Override
    public Solicitud obtenerSolicitudPorId(Integer id) {
        return null;
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        return null;
    }

    @Override
    public Solicitud actualizar(Solicitud solicitud, Integer id) {
        return null;
    }

    @Override
    public Solicitud eliminar(Integer id) {
        return null;
    }
}
