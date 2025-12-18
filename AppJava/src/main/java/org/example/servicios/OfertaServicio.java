package org.example.servicios;

import org.example.modelos.Oferta;

import java.util.List;

public interface OfertaServicio {
    public List<Oferta> obtenerOfertas();
    public Oferta obtenerOfertaPorId(Integer id);
    public Oferta guardar(Oferta oferta);
    public Oferta actualizar(Oferta oferta, Integer id);
    public Oferta eliminar(Integer id);
}
