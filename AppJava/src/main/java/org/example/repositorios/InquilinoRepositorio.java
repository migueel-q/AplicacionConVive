package org.example.repositorios;

import org.example.modelos.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InquilinoRepositorio extends JpaRepository<Inquilino,Integer> {
    Optional<Inquilino> findByEmailAndPassword(String email, String password);
    Inquilino findByEmail(String email);
}
