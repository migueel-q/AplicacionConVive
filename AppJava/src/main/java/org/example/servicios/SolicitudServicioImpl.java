package org.example.servicios;

import org.example.modelos.Solicitud;
import org.example.repositorios.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SolicitudServicioImpl implements  SolicitudServicio {
    @Autowired
    private SolicitudRepositorio solicitudRepositorio;
    @Override
    public List<Solicitud> obtenerSolicitudes() {
        return solicitudRepositorio.findAll();

    }

    @Override
    public Solicitud obtenerSolicitudPorId(Integer id) {
        return solicitudRepositorio.findById(id).orElse(null);
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        return solicitudRepositorio.save(solicitud);
    }

    @Override
    public Solicitud actualizar(Solicitud solicitud, Integer id) {
        Solicitud existe= solicitudRepositorio.findById(id).orElse(null);
        if (existe!=null){
            existe.setOferta(solicitud.getOferta());
            existe.setInquilino(solicitud.getInquilino());
            existe.setAceptado(solicitud.isAceptado());
            return solicitudRepositorio.save(existe);
        }
        return null;
    }

    @Override
    public Solicitud eliminar(Integer id) {
        Solicitud existente = solicitudRepositorio.findById(id).orElse(null);
        if (existente != null) {
            solicitudRepositorio.delete(existente);
        }
        return existente;
    }
}
