package org.example.servicios;

import org.example.DTO.OfertaDTO;
import org.example.modelos.Oferta;

import java.util.List;

public interface OfertaServicio {
    List<Oferta> obtenerOfertas();
    Oferta obtenerOfertaPorId(Integer id);
    Oferta guardar(Oferta oferta);
    Oferta actualizar(Oferta oferta, Integer id);
    Oferta eliminar(Integer id);
}
