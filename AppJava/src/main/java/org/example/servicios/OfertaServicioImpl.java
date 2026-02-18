package org.example.servicios;

import org.example.DTO.OfertaDTO;
import org.example.modelos.Oferta;
import org.example.repositorios.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfertaServicioImpl implements  OfertaServicio {
    @Autowired
    private OfertaRepositorio ofertaRepositorio;
    @Override
    public List<Oferta> obtenerOfertas() {
        return ofertaRepositorio.findAll();
    }
    @Override
    public Oferta obtenerOfertaPorId(Integer id) {
        return ofertaRepositorio.findById(id).orElse(null);
    }

    @Override
    public Oferta guardar(Oferta oferta) {
        return ofertaRepositorio.save(oferta);
    }

    @Override
    public Oferta actualizar(Oferta ofertaActualizar, Integer id) {
        Oferta oferta = ofertaRepositorio.findById(id).orElse(null);
        if (oferta != null) {
            oferta.setCantidad(ofertaActualizar.getCantidad());
            oferta.setDescripcion(ofertaActualizar.getDescripcion());
            oferta.setPiso(ofertaActualizar.getPiso());
            oferta.setSolicitudes(ofertaActualizar.getSolicitudes());
            oferta.setInquilino(ofertaActualizar.getInquilino());
            ofertaRepositorio.save(oferta);
        }
        return oferta;
    }

    @Override
    public Oferta eliminar(Integer id) {
        if (ofertaRepositorio.existsById(id)) {
            Oferta oferta=ofertaRepositorio.findById(id).get();
            ofertaRepositorio.delete(oferta);
            return oferta;
        }else{
            return null;
        }
    }
}
