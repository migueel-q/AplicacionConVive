package org.example.repositorios;

import org.example.modelos.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropietarioRepositorio extends JpaRepository<Propietario,Integer> {
    Optional<Propietario> findByEmailAndPassword(String email, String password);
    Propietario findByEmail(String correo);
}
