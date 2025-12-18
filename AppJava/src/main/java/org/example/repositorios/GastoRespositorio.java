package org.example.repositorios;

import org.example.modelos.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRespositorio extends JpaRepository<Gasto,Integer> {
}
