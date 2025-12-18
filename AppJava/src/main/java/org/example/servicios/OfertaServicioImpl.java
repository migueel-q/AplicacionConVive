package org.example.servicios;

import org.example.modelos.Oferta;

import java.util.List;

public class OfertaServicioImpl implements  OfertaServicio {
    @Override
    public List<Oferta> obtenerOfertas() {
        return List.of();
    }

    @Override
    public Oferta obtenerOfertaPorId(Integer id) {
        return null;
    }

    @Override
    public Oferta guardar(Oferta oferta) {
        return null;
    }

    @Override
    public Oferta actualizar(Oferta oferta, Integer id) {
        return null;
    }

    @Override
    public Oferta eliminar(Integer id) {
        return null;
    }
}
