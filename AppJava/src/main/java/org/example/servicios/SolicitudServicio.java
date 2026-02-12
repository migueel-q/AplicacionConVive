package org.example.servicios;

import org.example.DTO.SolicitudDTO;
import org.example.modelos.Solicitud;

import java.util.List;

public interface SolicitudServicio {
    List<Solicitud> obtenerSolicitudes();
    Solicitud obtenerSolicitudPorId(Integer id);
    Solicitud guardar(Solicitud solicitud);
    Solicitud actualizar(Solicitud solicitud, Integer id);
    Solicitud eliminar(Integer id);
}
