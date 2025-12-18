package org.example.repositorios;

import org.example.modelos.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquilinoRepositorio extends JpaRepository<Inquilino,Integer> {
}
