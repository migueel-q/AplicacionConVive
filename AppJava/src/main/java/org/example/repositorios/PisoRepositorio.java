package org.example.repositorios;

import org.example.modelos.Piso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PisoRepositorio extends JpaRepository<Piso,Integer> {
}
