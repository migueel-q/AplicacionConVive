package org.example.repositorios;

import org.example.modelos.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepositorio extends JpaRepository<Oferta,Integer> {
}
