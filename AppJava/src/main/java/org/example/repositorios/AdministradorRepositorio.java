package org.example.repositorios;

import org.example.modelos.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepositorio extends JpaRepository<Administrador,Integer> {
}
