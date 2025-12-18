package org.example.servicios;

import org.example.modelos.Solicitud;

import java.util.List;

public interface SolicitudServicio {
    public List<Solicitud>  obtenerSolicitudes();
    public Solicitud obtenerSolicitudPorId(Integer id);
    public Solicitud guardar(Solicitud solicitud);
    public Solicitud actualizar(Solicitud solicitud, Integer id);
    public Solicitud eliminar(Integer id);
}
