package org.example.repositorios;

import org.example.modelos.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepositorio extends JpaRepository<Solicitud,Integer> {

}
