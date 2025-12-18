package org.example.repositorios;

import org.example.modelos.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepositorio extends JpaRepository<Contrato,Integer> {
}
